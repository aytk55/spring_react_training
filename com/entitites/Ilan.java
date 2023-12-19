package ilanaraba.com.entitites;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Ilan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ilanbasligi;
    private String aciklama;

    @OneToMany(mappedBy = "ilan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> resimUrlList=new ArrayList<>();
    private String marka;
    private String model;
    private int yil;
    private String yakit;
    private String vites;
    private int kilometre;
    private String hasarkaydi;
    private String degisenParcalar;
    private String boyaliparcalar;
    private String kasatipi;
    private int fiyat;
    private String aracsahibi;
    private String instagram;
    private String konum;
    private String telefonnumarasi;
    private String ilantarihi;

    public Ilan(String ilanbasligi, String aciklama, List<Image> resimUrlList, String marka, String model, int yil, String yakit, String vites, int kilometre, String hasarkaydi, String degisenParcalar, String boyaliparcalar, String kasatipi, int fiyat, String aracsahibi, String instagram, String konum, String telefonnumarasi, String ilantarihi) {
        this.ilanbasligi = ilanbasligi;
        this.aciklama = aciklama;
        this.resimUrlList = resimUrlList;
        this.marka = marka;
        this.model = model;
        this.yil = yil;
        this.yakit = yakit;
        this.vites = vites;
        this.kilometre = kilometre;
        this.hasarkaydi = hasarkaydi;
        this.degisenParcalar = degisenParcalar;
        this.boyaliparcalar = boyaliparcalar;
        this.kasatipi = kasatipi;
        this.fiyat = fiyat;
        this.aracsahibi = aracsahibi;
        this.instagram = instagram;
        this.konum = konum;
        this.telefonnumarasi = telefonnumarasi;
        this.ilantarihi = ilantarihi;
    }

    public Ilan() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIlanbasligi() {
        return ilanbasligi;
    }

    public void setIlanbasligi(String ilanbasligi) {
        this.ilanbasligi = ilanbasligi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public List<Image> getResimUrlList() {
        return resimUrlList;
    }

    public void setResimUrlList(List<Image> resimUrlList) {
        this.resimUrlList = resimUrlList;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public String getYakit() {
        return yakit;
    }

    public void setYakit(String yakit) {
        this.yakit = yakit;
    }

    public String getVites() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }

    public int getKilometre() {
        return kilometre;
    }

    public void setKilometre(int kilometre) {
        this.kilometre = kilometre;
    }

    public String getHasarkaydi() {
        return hasarkaydi;
    }

    public void setHasarkaydi(String hasarkaydi) {
        this.hasarkaydi = hasarkaydi;
    }

    public String getDegisenParcalar() {
        return degisenParcalar;
    }

    public void setDegisenParcalar(String degisenParcalar) {
        this.degisenParcalar = degisenParcalar;
    }

    public String getBoyaliparcalar() {
        return boyaliparcalar;
    }

    public void setBoyaliparcalar(String boyaliparcalar) {
        this.boyaliparcalar = boyaliparcalar;
    }

    public String getKasatipi() {
        return kasatipi;
    }

    public void setKasatipi(String kasatipi) {
        this.kasatipi = kasatipi;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getAracsahibi() {
        return aracsahibi;
    }

    public void setAracsahibi(String aracsahibi) {
        this.aracsahibi = aracsahibi;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getKonum() {
        return konum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }

    public String getTelefonnumarasi() {
        return telefonnumarasi;
    }

    public void setTelefonnumarasi(String telefonnumarasi) {
        this.telefonnumarasi = telefonnumarasi;
    }

    public String getIlantarihi() {
        return ilantarihi;
    }

    public void setIlantarihi(String ilantarihi) {
        this.ilantarihi = ilantarihi;
    }
}
