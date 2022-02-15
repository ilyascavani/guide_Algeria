package com.guide.alger.nabilsoft.alger;

public class cinema {
    String adr;
    float deux;
    String fax;
    String img;
    String mail;
    String name;
    String ouvert;
    String prix;
    String site;
    String tel;
    float un;

    public cinema(float un, float deux, String name, String img, String pr, String ouvert, String adr, String tel, String fax, String mail, String site) {
        this.name = name;
        this.un = un;
        this.deux = deux;
        this.img = img;
        this.prix = pr;
        this.ouvert = ouvert;
        this.adr = adr;
        this.tel = tel;
        this.fax = fax;
        this.mail = mail;
        this.site = site;
    }

    public String getName() {
        return this.name;
    }

    public String getImg() {
        return this.img;
    }

    public String getPrix() {
        return this.prix;
    }

    public String getOuvert() {
        return this.ouvert;
    }

    public String getAdr() {
        return this.adr;
    }

    public String getTel() {
        return this.tel;
    }

    public String getFax() {
        return this.fax;
    }

    public String getMail() {
        return this.mail;
    }

    public String getSite() {
        return this.site;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPrix(String desc) {
        this.prix = desc;
    }

    public void setOuvert(String ouvert) {
        this.ouvert = ouvert;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
