package com.example.burgersiparis;

public class Burger {
    private long id;
    private String burgerIsmi;
    private long icecekId;
    private int ucret;
    private String aciklama;

    public Burger(){

    }

    public Burger(long id,String burgerIsmi,long icecekId,int ucret,String aciklama){
        this.id = id;
        this.burgerIsmi = burgerIsmi;
        this.icecekId = icecekId;
        this.ucret = ucret;
        this.aciklama = aciklama;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBurgerIsmi() {
        return burgerIsmi;
    }

    public void setBurgerIsmi(String burgerIsmi) {
        this.burgerIsmi = burgerIsmi;
    }

    public long getIcecekId() {
        return icecekId;
    }

    public void setIcecekId(long icecekId) {
        this.icecekId = icecekId;
    }

    public int getUcret() {
        return ucret;
    }

    public void setUcret(int ucret) {
        this.ucret = ucret;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
