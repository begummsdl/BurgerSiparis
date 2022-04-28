package com.example.burgersiparis;

public class Siparis {
    private long id;
    private long kullaniciId;
    private long burgerId;
    private int adet = 1;
    private int toplamUcret;

    public Siparis(){}

    public Siparis(long id,long kullaniciId,long burgerId,int adet,int burgerUcret){
        this.id = id;
        this.kullaniciId = kullaniciId;
        this.burgerId = burgerId;
        this.adet = adet;
        this.toplamUcret = (adet * burgerUcret);
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setKullaniciId(long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public long getKullaniciId() {
        return kullaniciId;
    }

    public void setBurgerId(long burgerId) {
        this.burgerId = burgerId;
    }

    public long getBurgerId() {
        return burgerId;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public int getAdet() {
        return adet;
    }

    public void setToplamUcret(int burgerUcret) {
        this.toplamUcret = this.adet * burgerUcret;
    }

    public int getToplamUcret() {
        return toplamUcret;
    }
}
