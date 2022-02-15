package com.guide.alger.nabilsoft.alger;

public class parc {
    String adr;
    String desc;
    float deux;
    String fax;
    String img;
    String mail;
    String name;
    String ouv;
    String site;
    String tarif;
    String tel;
    float un;

    public parc(float f, float f2, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) {
        this.name = string2;
        this.un = f;
        this.deux = f2;
        this.desc = string4;
        this.tarif = string10;
        this.ouv = string11;
        this.adr = string5;
        this.tel = string6;
        this.fax = string7;
        this.mail = string8;
        this.site = string9;
        this.img = string3;
    }

    public parc(String string2) {
        this.name = string2;
    }

    public String getAdr() {
        return this.adr;
    }

    public String getDesc() {
        return this.desc;
    }

    public float getDeux() {
        return this.deux;
    }

    public String getFax() {
        return this.fax;
    }

    public String getImg() {
        return this.img;
    }

    public String getMail() {
        return this.mail;
    }

    public String getName() {
        return this.name;
    }

    public String getOuv() {
        return this.ouv;
    }

    public String getSite() {
        return this.site;
    }

    public String getTarif() {
        return this.tarif;
    }

    public String getTel() {
        return this.tel;
    }

    public float getUn() {
        return this.un;
    }

    public void setAdr(String string2) {
        this.adr = string2;
    }

    public void setDesc(String string2) {
        this.desc = string2;
    }

    public void setDeux(float f) {
        this.deux = f;
    }

    public void setFax(String string2) {
        this.fax = string2;
    }

    public void setImg(String string2) {
        this.img = string2;
    }

    public void setMail(String string2) {
        this.mail = string2;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setOuv(String string2) {
        this.ouv = string2;
    }

    public void setSite(String string2) {
        this.site = string2;
    }

    public void setTarif(String string2) {
        this.tarif = string2;
    }

    public void setTel(String string2) {
        this.tel = string2;
    }

    public void setUn(float f) {
        this.un = f;
    }
}
