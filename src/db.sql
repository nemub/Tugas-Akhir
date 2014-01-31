SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `ta-sahal` ;
CREATE SCHEMA IF NOT EXISTS `ta-sahal` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `ta-sahal` ;

-- -----------------------------------------------------
-- Table `pengguna`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pengguna` ;

CREATE TABLE IF NOT EXISTS `pengguna` (
  `id_pengguna` INT NOT NULL AUTO_INCREMENT,
  `nama` VARCHAR(20) NOT NULL,
  `nik` VARCHAR(5) NOT NULL,
  `bagian` ENUM('Quality','Produksi','Maintenance','Engineering') NOT NULL,
  `jabatan` ENUM('Worker','Ast.Foreman','Foreman','Supervisor','Manager') NOT NULL DEFAULT 'Worker',
  PRIMARY KEY (`id_pengguna`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `akses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `akses` ;

CREATE TABLE IF NOT EXISTS `akses` (
  `id_akses` INT NOT NULL AUTO_INCREMENT,
  `sandi` VARCHAR(12) NOT NULL,
  `hak` ENUM('Admin','Inspector','Pengguna','Pimpinan') NOT NULL DEFAULT 'Pengguna',
  `pengguna` INT NOT NULL,
  PRIMARY KEY (`id_akses`),
  CONSTRAINT `fk_akses_pengguna1`
    FOREIGN KEY (`pengguna`)
    REFERENCES `pengguna` (`id_pengguna`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_akses_pengguna1_idx` ON `akses` (`pengguna` ASC);


-- -----------------------------------------------------
-- Table `vendor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vendor` ;

CREATE TABLE IF NOT EXISTS `vendor` (
  `id_vendor` INT NOT NULL AUTO_INCREMENT,
  `nama` VARCHAR(50) NOT NULL,
  `kode` VARCHAR(5) NOT NULL,
  `telepon` VARCHAR(24) NULL,
  `email` VARCHAR(45) NULL,
  `alamat` TEXT NULL,
  PRIMARY KEY (`id_vendor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `alat_ukur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `alat_ukur` ;

CREATE TABLE IF NOT EXISTS `alat_ukur` (
  `id_alat_ukur` INT NOT NULL AUTO_INCREMENT,
  `serial` VARCHAR(45) NOT NULL,
  `kode` VARCHAR(10) NOT NULL,
  `nama` VARCHAR(45) NOT NULL,
  `standar` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `lokasi` VARCHAR(45) NOT NULL,
  `vendor` INT NOT NULL,
  `jumlah` INT NOT NULL DEFAULT 0,
  `tanggal_beli` DATE NOT NULL,
  `tipe` ENUM('Alat Ukur','Alat Inspeksi') NOT NULL,
  PRIMARY KEY (`id_alat_ukur`),
  CONSTRAINT `fk_alat_ukur_vendor1`
    FOREIGN KEY (`vendor`)
    REFERENCES `vendor` (`id_vendor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_alat_ukur_vendor1_idx` ON `alat_ukur` (`vendor` ASC);


-- -----------------------------------------------------
-- Table `jadwal_kalibrasi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jadwal_kalibrasi` ;

CREATE TABLE IF NOT EXISTS `jadwal_kalibrasi` (
  `id_jadwal_kalibrasi` INT NOT NULL AUTO_INCREMENT,
  `alat_ukur` INT NOT NULL,
  `tanggal` DATE NOT NULL,
  `tempat` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_jadwal_kalibrasi`),
  CONSTRAINT `fk_jadwal_kalibrasi_alat_ukur1`
    FOREIGN KEY (`alat_ukur`)
    REFERENCES `alat_ukur` (`id_alat_ukur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_jadwal_kalibrasi_alat_ukur1_idx` ON `jadwal_kalibrasi` (`alat_ukur` ASC);


-- -----------------------------------------------------
-- Table `data_kalibrasi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `data_kalibrasi` ;

CREATE TABLE IF NOT EXISTS `data_kalibrasi` (
  `id_data_kalibrasi` INT NOT NULL AUTO_INCREMENT,
  `nomor_laporan` VARCHAR(45) NOT NULL,
  `jadwal_kalibrasi` INT NOT NULL,
  `pelanggan` TEXT NOT NULL,
  `standar` TEXT NOT NULL,
  `metode` VARCHAR(45) NULL,
  `acuan` VARCHAR(45) NOT NULL,
  `ketelitian_go` VARCHAR(50) NOT NULL,
  `ketilitian_ng` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_data_kalibrasi`),
  CONSTRAINT `fk_hasil_kalibrasi_jadwal_kalibrasi1`
    FOREIGN KEY (`jadwal_kalibrasi`)
    REFERENCES `jadwal_kalibrasi` (`id_jadwal_kalibrasi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_hasil_kalibrasi_jadwal_kalibrasi1_idx` ON `data_kalibrasi` (`jadwal_kalibrasi` ASC);


-- -----------------------------------------------------
-- Table `data_hasil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `data_hasil` ;

CREATE TABLE IF NOT EXISTS `data_hasil` (
  `id_data_hasil` INT NOT NULL AUTO_INCREMENT,
  `posisi_alat` VARCHAR(45) NOT NULL,
  `deviasi` VARCHAR(45) NOT NULL,
  `type` ENUM('GO','NOT GO') NOT NULL,
  PRIMARY KEY (`id_data_hasil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hasil_kalibrasi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hasil_kalibrasi` ;

CREATE TABLE IF NOT EXISTS `hasil_kalibrasi` (
  `id_hasil_kalibrasi` INT NOT NULL AUTO_INCREMENT,
  `data_kalibrasi` INT NOT NULL,
  `data_hasil` INT NOT NULL,
  `hasil` ENUM('OK','NG') NOT NULL,
  PRIMARY KEY (`id_hasil_kalibrasi`),
  CONSTRAINT `fk_hasil_kalibrasi_data_kalibrasi1`
    FOREIGN KEY (`data_kalibrasi`)
    REFERENCES `data_kalibrasi` (`id_data_kalibrasi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hasil_kalibrasi_data_hasil1`
    FOREIGN KEY (`data_hasil`)
    REFERENCES `data_hasil` (`id_data_hasil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_hasil_kalibrasi_data_kalibrasi1_idx` ON `hasil_kalibrasi` (`data_kalibrasi` ASC);

CREATE INDEX `fk_hasil_kalibrasi_data_hasil1_idx` ON `hasil_kalibrasi` (`data_hasil` ASC);


-- -----------------------------------------------------
-- Table `pesanan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pesanan` ;

CREATE TABLE IF NOT EXISTS `pesanan` (
  `id_pesanan` INT NOT NULL AUTO_INCREMENT,
  `no_pesan` VARCHAR(45) NOT NULL,
  `alat_ukur` INT NOT NULL,
  `pengguna` INT NOT NULL,
  `jumlah` INT NOT NULL,
  `tanggal` DATE NOT NULL,
  PRIMARY KEY (`id_pesanan`),
  CONSTRAINT `fk_pesanan_alat_ukur1`
    FOREIGN KEY (`alat_ukur`)
    REFERENCES `alat_ukur` (`id_alat_ukur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pesanan_pengguna1`
    FOREIGN KEY (`pengguna`)
    REFERENCES `pengguna` (`id_pengguna`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_pesanan_alat_ukur1_idx` ON `pesanan` (`alat_ukur` ASC);

CREATE INDEX `fk_pesanan_pengguna1_idx` ON `pesanan` (`pengguna` ASC);


-- -----------------------------------------------------
-- Table `po`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `po` ;

CREATE TABLE IF NOT EXISTS `po` (
  `id_po` INT NOT NULL AUTO_INCREMENT,
  `pesanan` INT NOT NULL,
  `pengguna` INT NOT NULL,
  `kode_po` VARCHAR(45) NOT NULL,
  `keterangan` TEXT NOT NULL,
  `waktu` VARCHAR(45) NOT NULL,
  `alasan` VARCHAR(100) NOT NULL,
  `harga` INT NOT NULL,
  `tanggal` DATE NOT NULL,
  `status` ENUM('Proses','Terima','Tolak') NOT NULL DEFAULT 'Proses',
  PRIMARY KEY (`id_po`),
  CONSTRAINT `fk_po_pesanan1`
    FOREIGN KEY (`pesanan`)
    REFERENCES `pesanan` (`id_pesanan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_po_pengguna1`
    FOREIGN KEY (`pengguna`)
    REFERENCES `pengguna` (`id_pengguna`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_po_pesanan1_idx` ON `po` (`pesanan` ASC);

CREATE INDEX `fk_po_pengguna1_idx` ON `po` (`pengguna` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
