package com.example.burgersiparis;

public class Yetki {
    private long id;
    private String yetkiIsmi;

    public Yetki(){}

    public Yetki(long id,String yetkiIsmi){
        this.id = id;
        this.yetkiIsmi = yetkiIsmi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYetkiIsmi() {
        return yetkiIsmi;
    }

    public void setYetkiIsmi(String yetkiIsmi) {
        this.yetkiIsmi = yetkiIsmi;
    }
}
