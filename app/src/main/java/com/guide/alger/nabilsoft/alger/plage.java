package com.guide.alger.nabilsoft.alger;

public class plage {
    String desc;
    float deux;
    String img;
    String name;
    float un;

    public plage(String string2, float f, float f2, String string3, String string4) {
        this.name = string2;
        this.un = f;
        this.deux = f2;
        this.img = string3;
        this.desc = string4;
    }

    public plage(String string2, String string3) {
        this.name = string2;
        this.img = string3;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getImg() {
        return this.img;
    }

    public String getName() {
        return this.name;
    }

    public void setDesc(String string2) {
        this.desc = string2;
    }

    public void setImg(String string2) {
        this.img = string2;
    }

    public void setName(String string2) {
        this.name = string2;
    }
}
