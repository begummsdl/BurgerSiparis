package com.example.burgersiparis;

public class Kullanici {
    private long id;
    private long yetkiId;
    private String isim;
    private String soyisim;
    private String sifre;
    private String telefon;
    private String konum;
    private String email;

    public Kullanici(){}

    public Kullanici(long id, String isim,String soyisim,String sifre,String telefon,String konum,String email,long yetkiId){
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.sifre = sifre;
        this.telefon = telefon;
        this.konum = konum;
        this.email = email;
        this.yetkiId = yetkiId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getYetkiId() {
        return yetkiId;
    }

    public void setYetkiId(long yetkiId) {
        this.yetkiId = yetkiId;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getKonum() {
        return konum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
