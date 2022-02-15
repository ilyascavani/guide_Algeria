package com.guide.alger.nabilsoft.alger;

public class th {
    String adr;
    String desc;
    float deux;
    String fax;
    String img;
    String mail;
    String name;
    String site;
    String tel;
    float un;

    public th(float un, float deux, String name, String img, String dsc, String adr, String tel, String fax, String mail, String site) {
        this.name = name;
        this.un = un;
        this.deux = deux;
        this.img = img;
        this.desc = dsc;
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

    public String getDesc() {
        return this.desc;
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

    public void setDesc(String desc) {
        this.desc = desc;
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
