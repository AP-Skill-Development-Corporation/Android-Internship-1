package com.example.cherry.carparking;

public class Pojo {
    String n,number,st,et,k,defValue;

    public String getN() {
        return n;
    }

    public String getNumber() {
        return number;
    }

    public String getSt() {
        return st;
    }

    public String getEt() {
        return et;
    }

    public String getK() {
        return k;
    }

    public String getDefValue() {
        return defValue;
    }

    public Pojo(String n, String number, String st, String et, String k, String defValue) {
        this.n = n;
        this.number = number;
        this.st = st;
        this.et = et;
        this.k = k;
        this.defValue = defValue;
    }
}
