CREATE DATABASE  IF NOT EXISTS `ta-sahal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ta-sahal`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: ta-sahal
-- ------------------------------------------------------
-- Server version	5.1.30-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `akses`
--

DROP TABLE IF EXISTS `akses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `akses` (
  `id_akses` int(11) NOT NULL AUTO_INCREMENT,
  `sandi` varchar(12) NOT NULL,
  `hak` enum('Admin','Inspector','Pengguna','Pimpinan') NOT NULL DEFAULT 'Pengguna',
  `pengguna` int(11) NOT NULL,
  PRIMARY KEY (`id_akses`),
  KEY `fk_akses_pengguna1_idx` (`pengguna`),
  CONSTRAINT `fk_akses_pengguna1` FOREIGN KEY (`pengguna`) REFERENCES `pengguna` (`id_pengguna`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `akses`
--

LOCK TABLES `akses` WRITE;
/*!40000 ALTER TABLE `akses` DISABLE KEYS */;
INSERT INTO `akses` VALUES (1,'00000','Admin',1);
/*!40000 ALTER TABLE `akses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alat_ukur`
--

DROP TABLE IF EXISTS `alat_ukur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alat_ukur` (
  `id_alat_ukur` int(11) NOT NULL AUTO_INCREMENT,
  `serial` varchar(45) NOT NULL,
  `kode` varchar(10) NOT NULL,
  `nama` varchar(45) NOT NULL,
  `standar` varchar(45) NOT NULL,
  `jumlah` int(11) NOT NULL DEFAULT '1',
  `model` varchar(45) NOT NULL,
  `lokasi` varchar(45) NOT NULL,
  `vendor` int(11) NOT NULL,
  `tanggal_beli` date NOT NULL,
  `tipe` enum('Alat Ukur','Alat Inspeksi') NOT NULL,
  PRIMARY KEY (`id_alat_ukur`),
  KEY `fk_alat_ukur_vendor1_idx` (`vendor`),
  CONSTRAINT `fk_alat_ukur_vendor1` FOREIGN KEY (`vendor`) REFERENCES `vendor` (`id_vendor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alat_ukur`
--

LOCK TABLES `alat_ukur` WRITE;
/*!40000 ALTER TABLE `alat_ukur` DISABLE KEYS */;
/*!40000 ALTER TABLE `alat_ukur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_hasil`
--

DROP TABLE IF EXISTS `data_hasil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_hasil` (
  `id_data_hasil` int(11) NOT NULL AUTO_INCREMENT,
  `posisi_alat` varchar(45) NOT NULL,
  `deviasi` varchar(45) NOT NULL,
  `type` enum('GO','NOT GO') NOT NULL,
  PRIMARY KEY (`id_data_hasil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_hasil`
--

LOCK TABLES `data_hasil` WRITE;
/*!40000 ALTER TABLE `data_hasil` DISABLE KEYS */;
/*!40000 ALTER TABLE `data_hasil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_kalibrasi`
--

DROP TABLE IF EXISTS `data_kalibrasi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_kalibrasi` (
  `id_data_kalibrasi` int(11) NOT NULL AUTO_INCREMENT,
  `nomor_laporan` varchar(45) NOT NULL,
  `jadwal_kalibrasi` int(11) NOT NULL,
  `pelanggan` text NOT NULL,
  `standar` text NOT NULL,
  `metode` varchar(45) DEFAULT NULL,
  `acuan` varchar(45) NOT NULL,
  `ketelitian_go` varchar(50) NOT NULL,
  `ketilitian_ng` varchar(45) NOT NULL,
  PRIMARY KEY (`id_data_kalibrasi`),
  KEY `fk_hasil_kalibrasi_jadwal_kalibrasi1_idx` (`jadwal_kalibrasi`),
  CONSTRAINT `fk_hasil_kalibrasi_jadwal_kalibrasi1` FOREIGN KEY (`jadwal_kalibrasi`) REFERENCES `jadwal_kalibrasi` (`id_jadwal_kalibrasi`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_kalibrasi`
--

LOCK TABLES `data_kalibrasi` WRITE;
/*!40000 ALTER TABLE `data_kalibrasi` DISABLE KEYS */;
/*!40000 ALTER TABLE `data_kalibrasi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hasil_kalibrasi`
--

DROP TABLE IF EXISTS `hasil_kalibrasi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hasil_kalibrasi` (
  `id_hasil_kalibrasi` int(11) NOT NULL AUTO_INCREMENT,
  `data_kalibrasi` int(11) NOT NULL,
  `data_hasil` int(11) NOT NULL,
  `hasil` enum('OK','NG') NOT NULL,
  PRIMARY KEY (`id_hasil_kalibrasi`),
  KEY `fk_hasil_kalibrasi_data_kalibrasi1_idx` (`data_kalibrasi`),
  KEY `fk_hasil_kalibrasi_data_hasil1_idx` (`data_hasil`),
  CONSTRAINT `fk_hasil_kalibrasi_data_hasil1` FOREIGN KEY (`data_hasil`) REFERENCES `data_hasil` (`id_data_hasil`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_hasil_kalibrasi_data_kalibrasi1` FOREIGN KEY (`data_kalibrasi`) REFERENCES `data_kalibrasi` (`id_data_kalibrasi`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hasil_kalibrasi`
--

LOCK TABLES `hasil_kalibrasi` WRITE;
/*!40000 ALTER TABLE `hasil_kalibrasi` DISABLE KEYS */;
/*!40000 ALTER TABLE `hasil_kalibrasi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jadwal_kalibrasi`
--

DROP TABLE IF EXISTS `jadwal_kalibrasi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jadwal_kalibrasi` (
  `id_jadwal_kalibrasi` int(11) NOT NULL AUTO_INCREMENT,
  `alat_ukur` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `tempat` varchar(45) NOT NULL,
  PRIMARY KEY (`id_jadwal_kalibrasi`),
  KEY `fk_jadwal_kalibrasi_alat_ukur1_idx` (`alat_ukur`),
  CONSTRAINT `fk_jadwal_kalibrasi_alat_ukur1` FOREIGN KEY (`alat_ukur`) REFERENCES `alat_ukur` (`id_alat_ukur`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jadwal_kalibrasi`
--

LOCK TABLES `jadwal_kalibrasi` WRITE;
/*!40000 ALTER TABLE `jadwal_kalibrasi` DISABLE KEYS */;
/*!40000 ALTER TABLE `jadwal_kalibrasi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pengguna`
--

DROP TABLE IF EXISTS `pengguna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pengguna` (
  `id_pengguna` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(20) NOT NULL,
  `nik` varchar(5) NOT NULL,
  `bagian` enum('Quality','Produksi','Maintenance','Engineering') NOT NULL,
  `jabatan` enum('Worker','Ast.Foreman','Foreman','Supervisor','Manager') NOT NULL DEFAULT 'Worker',
  PRIMARY KEY (`id_pengguna`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pengguna`
--

LOCK TABLES `pengguna` WRITE;
/*!40000 ALTER TABLE `pengguna` DISABLE KEYS */;
INSERT INTO `pengguna` VALUES (1,'Root Admin','000','Maintenance','Manager');
/*!40000 ALTER TABLE `pengguna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pesanan`
--

DROP TABLE IF EXISTS `pesanan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pesanan` (
  `id_pesanan` int(11) NOT NULL AUTO_INCREMENT,
  `no_pesan` varchar(45) NOT NULL,
  `alat_ukur` int(11) NOT NULL,
  `pengguna` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  PRIMARY KEY (`id_pesanan`),
  KEY `fk_pesanan_alat_ukur1_idx` (`alat_ukur`),
  KEY `fk_pesanan_pengguna1_idx` (`pengguna`),
  CONSTRAINT `fk_pesanan_alat_ukur1` FOREIGN KEY (`alat_ukur`) REFERENCES `alat_ukur` (`id_alat_ukur`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pesanan_pengguna1` FOREIGN KEY (`pengguna`) REFERENCES `pengguna` (`id_pengguna`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pesanan`
--

LOCK TABLES `pesanan` WRITE;
/*!40000 ALTER TABLE `pesanan` DISABLE KEYS */;
/*!40000 ALTER TABLE `pesanan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `po`
--

DROP TABLE IF EXISTS `po`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `po` (
  `id_po` int(11) NOT NULL AUTO_INCREMENT,
  `pesanan` int(11) NOT NULL,
  `pengguna` int(11) NOT NULL,
  `kode_po` varchar(45) NOT NULL,
  `keterangan` text NOT NULL,
  `waktu` varchar(45) NOT NULL,
  `alasan` varchar(100) NOT NULL,
  `harga` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `status` enum('Proses','Terima','Tolak') NOT NULL DEFAULT 'Proses',
  PRIMARY KEY (`id_po`),
  KEY `fk_po_pesanan1_idx` (`pesanan`),
  KEY `fk_po_pengguna1_idx` (`pengguna`),
  CONSTRAINT `fk_po_pengguna1` FOREIGN KEY (`pengguna`) REFERENCES `pengguna` (`id_pengguna`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_po_pesanan1` FOREIGN KEY (`pesanan`) REFERENCES `pesanan` (`id_pesanan`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `po`
--

LOCK TABLES `po` WRITE;
/*!40000 ALTER TABLE `po` DISABLE KEYS */;
/*!40000 ALTER TABLE `po` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `id_vendor` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `kode` varchar(5) NOT NULL,
  `telepon` varchar(24) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `alamat` text,
  PRIMARY KEY (`id_vendor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-31 15:07:54
