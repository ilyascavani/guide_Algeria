package com.guide.alger.nabilsoft.alger;

public class hopital {
    String adr;
    String desc;
    float deux;
    String email;
    String fax;
    String name;
    String site;
    String telephone;
    float un;

    public hopital(float un, float deux, String name, String desc, String adr, String telephone, String fax, String email, String site) {
        this.name = name;
        this.un = un;
        this.deux = deux;
        this.desc = desc;
        this.adr = adr;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;
        this.site = site;
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

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSite(String site) {
        this.site = site;
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

    public String getTelephone() {
        return this.telephone;
    }

    public String getFax() {
        return this.fax;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSite() {
        return this.site;
    }
}
