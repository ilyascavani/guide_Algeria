package com.guide.alger.nabilsoft.alger;

public class resto {
    String adr;
    String desc;
    float deux;
    String fax;
    String img;
    String mail;
    String name;
    String ouvert;
    String site;
    String tel;
    float un;

    public resto(float f, float f2, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
        this.name = string2;
        this.un = f;
        this.deux = f2;
        this.img = string3;
        this.desc = string4;
        this.ouvert = string5;
        this.adr = string6;
        this.tel = string7;
        this.fax = string8;
        this.mail = string9;
        this.site = string10;
    }

    public resto(String string2, String string3) {
        this.name = string2;
        this.img = string3;
    }

    public String getAdr() {
        return this.adr;
    }

    public String getDesc() {
        return this.desc;
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

    public String getOuvert() {
        return this.ouvert;
    }

    public String getSite() {
        return this.site;
    }

    public String getTel() {
        return this.tel;
    }

    public void setAdr(String string2) {
        this.adr = string2;
    }

    public void setDesc(String string2) {
        this.desc = string2;
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

    public void setOuvert(String string2) {
        this.ouvert = string2;
    }

    public void setSite(String string2) {
        this.site = string2;
    }

    public void setTel(String string2) {
        this.tel = string2;
    }
}
