package com.guide.alger.nabilsoft.alger;
public class hotel {
    String adr;
    String desc;
    float deux;
    String email;
    int et;
    String fax;
    String img;
    String img1;
    String img2;
    String img3;
    String mobile;
    String name;
    String prix;
    String site;
    String telephone;
    float un;
    String unit;

    public hotel(String name, float un, float deux, String adr, int et, String img, String prix, String unit, String telephone, String mobile, String fax, String email, String site, String desc, String img11, String img22, String img33) {
        this.name = name;
        this.un = un;
        this.deux = deux;
        this.adr = adr;
        this.et = et;
        this.img = img;
        this.prix = prix;
        this.unit = unit;
        this.telephone = telephone;
        this.mobile = mobile;
        this.fax = fax;
        this.email = email;
        this.site = site;
        this.desc = desc;
        this.img1 = img11;
        this.img2 = img22;
        this.img3 = img33;
    }

    public hotel(String name, String o) {
        this.name = name;
        this.img = o;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public void setEt(int et) {
        this.et = et;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return this.name;
    }

    public String getAdr() {
        return this.adr;
    }

    public int getEt() {
        return this.et;
    }

    public String getImg() {
        return this.img;
    }

    public String getPrix() {
        return this.prix;
    }

    public String getUnit() {
        return this.unit;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String getMobile() {
        return this.mobile;
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

    public String getDesc() {
        return this.desc;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg1() {
        return this.img1;
    }

    public String getImg2() {
        return this.img2;
    }

    public String getImg3() {
        return this.img3;
    }
}
