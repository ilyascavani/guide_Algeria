package com.guide.alger.nabilsoft.alger;

public class assurance {
    String adr;
    String desc;
    String fax;
    String mail;
    String name;
    String site;
    String tel;

    public assurance(String name, String desc, String adr, String tel, String fax, String mail, String site) {
        this.name = name;
        this.desc = desc;
        this.adr = adr;
        this.tel = tel;
        this.fax = fax;
        this.mail = mail;
        this.site = site;
    }

    public assurance(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
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
