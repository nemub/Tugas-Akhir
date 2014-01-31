package ta.util.orm.mapping;
// Generated Jan 31, 2014 3:09:33 PM by Hibernate Tools 3.6.0


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
 * Pesanan generated by hbm2java
 */
@Entity
@Table(name="pesanan"
    ,catalog="`TA-SAHAL`"
)
public class Pesanan  implements java.io.Serializable {


     private Integer idPesanan;
     private Pengguna pengguna;
     private AlatUkur alatUkur;
     private String noPesan;
     private int jumlah;
     private Date tanggal;
     private Set<Po> pos = new HashSet<Po>(0);

    public Pesanan() {
    }

	
    public Pesanan(Pengguna pengguna, AlatUkur alatUkur, String noPesan, int jumlah, Date tanggal) {
        this.pengguna = pengguna;
        this.alatUkur = alatUkur;
        this.noPesan = noPesan;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
    }
    public Pesanan(Pengguna pengguna, AlatUkur alatUkur, String noPesan, int jumlah, Date tanggal, Set<Po> pos) {
       this.pengguna = pengguna;
       this.alatUkur = alatUkur;
       this.noPesan = noPesan;
       this.jumlah = jumlah;
       this.tanggal = tanggal;
       this.pos = pos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_pesanan", unique=true, nullable=false)
    public Integer getIdPesanan() {
        return this.idPesanan;
    }
    
    public void setIdPesanan(Integer idPesanan) {
        this.idPesanan = idPesanan;
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
    @JoinColumn(name="alat_ukur", nullable=false)
    public AlatUkur getAlatUkur() {
        return this.alatUkur;
    }
    
    public void setAlatUkur(AlatUkur alatUkur) {
        this.alatUkur = alatUkur;
    }

    
    @Column(name="no_pesan", nullable=false, length=45)
    public String getNoPesan() {
        return this.noPesan;
    }
    
    public void setNoPesan(String noPesan) {
        this.noPesan = noPesan;
    }

    
    @Column(name="jumlah", nullable=false)
    public int getJumlah() {
        return this.jumlah;
    }
    
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="tanggal", nullable=false, length=10)
    public Date getTanggal() {
        return this.tanggal;
    }
    
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="pesanan")
    public Set<Po> getPos() {
        return this.pos;
    }
    
    public void setPos(Set<Po> pos) {
        this.pos = pos;
    }




}


