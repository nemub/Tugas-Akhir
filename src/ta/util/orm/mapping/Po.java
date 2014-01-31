package ta.util.orm.mapping;
// Generated Jan 31, 2014 4:08:54 PM by Hibernate Tools 3.6.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Po generated by hbm2java
 */
@Entity
@Table(name="po"
    ,catalog="`TA-SAHAL`"
)
public class Po  implements java.io.Serializable {


     private Integer idPo;
     private Pengguna pengguna;
     private Pesanan pesanan;
     private String kodePo;
     private String keterangan;
     private String waktu;
     private String alasan;
     private int harga;
     private Date tanggal;
     private String status;

    public Po() {
    }

    public Po(Pengguna pengguna, Pesanan pesanan, String kodePo, String keterangan, String waktu, String alasan, int harga, Date tanggal, String status) {
       this.pengguna = pengguna;
       this.pesanan = pesanan;
       this.kodePo = kodePo;
       this.keterangan = keterangan;
       this.waktu = waktu;
       this.alasan = alasan;
       this.harga = harga;
       this.tanggal = tanggal;
       this.status = status;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_po", unique=true, nullable=false)
    public Integer getIdPo() {
        return this.idPo;
    }
    
    public void setIdPo(Integer idPo) {
        this.idPo = idPo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pengguna", nullable=false)
    public Pengguna getPengguna() {
        return this.pengguna;
    }
    
    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pesanan", nullable=false)
    public Pesanan getPesanan() {
        return this.pesanan;
    }
    
    public void setPesanan(Pesanan pesanan) {
        this.pesanan = pesanan;
    }

    
    @Column(name="kode_po", nullable=false, length=45)
    public String getKodePo() {
        return this.kodePo;
    }
    
    public void setKodePo(String kodePo) {
        this.kodePo = kodePo;
    }

    
    @Column(name="keterangan", nullable=false, length=65535)
    public String getKeterangan() {
        return this.keterangan;
    }
    
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    
    @Column(name="waktu", nullable=false, length=45)
    public String getWaktu() {
        return this.waktu;
    }
    
    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    
    @Column(name="alasan", nullable=false, length=100)
    public String getAlasan() {
        return this.alasan;
    }
    
    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    
    @Column(name="harga", nullable=false)
    public int getHarga() {
        return this.harga;
    }
    
    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="tanggal", nullable=false, length=10)
    public Date getTanggal() {
        return this.tanggal;
    }
    
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    
    @Column(name="status", nullable=false, length=7)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


