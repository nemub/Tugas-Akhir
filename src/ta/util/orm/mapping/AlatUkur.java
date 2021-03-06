package ta.util.orm.mapping;
// Generated Jan 31, 2014 4:08:54 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AlatUkur generated by hbm2java
 */
@Entity
@Table(name="alat_ukur"
    ,catalog="`TA-SAHAL`"
)
public class AlatUkur  implements java.io.Serializable {


     private Integer idAlatUkur;
     private Vendor vendor;
     private String serial;
     private String kode;
     private String nama;
     private String standar;
     private int jumlah;
     private String model;
     private String lokasi;
     private Date tanggalBeli;
     private String tipe;
     private Set<Pesanan> pesanans = new HashSet<Pesanan>(0);
     private Set<JadwalKalibrasi> jadwalKalibrasis = new HashSet<JadwalKalibrasi>(0);

    public AlatUkur() {
    }

	
    public AlatUkur(Vendor vendor, String serial, String kode, String nama, String standar, int jumlah, String model, String lokasi, Date tanggalBeli, String tipe) {
        this.vendor = vendor;
        this.serial = serial;
        this.kode = kode;
        this.nama = nama;
        this.standar = standar;
        this.jumlah = jumlah;
        this.model = model;
        this.lokasi = lokasi;
        this.tanggalBeli = tanggalBeli;
        this.tipe = tipe;
    }
    public AlatUkur(Vendor vendor, String serial, String kode, String nama, String standar, int jumlah, String model, String lokasi, Date tanggalBeli, String tipe, Set<Pesanan> pesanans, Set<JadwalKalibrasi> jadwalKalibrasis) {
       this.vendor = vendor;
       this.serial = serial;
       this.kode = kode;
       this.nama = nama;
       this.standar = standar;
       this.jumlah = jumlah;
       this.model = model;
       this.lokasi = lokasi;
       this.tanggalBeli = tanggalBeli;
       this.tipe = tipe;
       this.pesanans = pesanans;
       this.jadwalKalibrasis = jadwalKalibrasis;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_alat_ukur", unique=true, nullable=false)
    public Integer getIdAlatUkur() {
        return this.idAlatUkur;
    }
    
    public void setIdAlatUkur(Integer idAlatUkur) {
        this.idAlatUkur = idAlatUkur;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vendor", nullable=false)
    public Vendor getVendor() {
        return this.vendor;
    }
    
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    
    @Column(name="serial", nullable=false, length=45)
    public String getSerial() {
        return this.serial;
    }
    
    public void setSerial(String serial) {
        this.serial = serial;
    }

    
    @Column(name="kode", nullable=false, length=10)
    public String getKode() {
        return this.kode;
    }
    
    public void setKode(String kode) {
        this.kode = kode;
    }

    
    @Column(name="nama", nullable=false, length=45)
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    
    @Column(name="standar", nullable=false, length=45)
    public String getStandar() {
        return this.standar;
    }
    
    public void setStandar(String standar) {
        this.standar = standar;
    }

    
    @Column(name="jumlah", nullable=false)
    public int getJumlah() {
        return this.jumlah;
    }
    
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    
    @Column(name="model", nullable=false, length=45)
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }

    
    @Column(name="lokasi", nullable=false, length=45)
    public String getLokasi() {
        return this.lokasi;
    }
    
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="tanggal_beli", nullable=false, length=10)
    public Date getTanggalBeli() {
        return this.tanggalBeli;
    }
    
    public void setTanggalBeli(Date tanggalBeli) {
        this.tanggalBeli = tanggalBeli;
    }

    
    @Column(name="tipe", nullable=false, length=13)
    public String getTipe() {
        return this.tipe;
    }
    
    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="alatUkur")
    public Set<Pesanan> getPesanans() {
        return this.pesanans;
    }
    
    public void setPesanans(Set<Pesanan> pesanans) {
        this.pesanans = pesanans;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="alatUkur")
    public Set<JadwalKalibrasi> getJadwalKalibrasis() {
        return this.jadwalKalibrasis;
    }
    
    public void setJadwalKalibrasis(Set<JadwalKalibrasi> jadwalKalibrasis) {
        this.jadwalKalibrasis = jadwalKalibrasis;
    }




}


