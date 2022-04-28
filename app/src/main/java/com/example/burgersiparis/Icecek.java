package com.example.burgersiparis;

public class Icecek {
    private long id;
    private String icecekIsmi;

    public Icecek(){}

    public Icecek(long id,String icecekIsmi){
        this.id = id;
        this.icecekIsmi = icecekIsmi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String icecekIsmi){
        this.icecekIsmi = icecekIsmi;
    }

    public String getName() {
        return icecekIsmi;
    }
}
