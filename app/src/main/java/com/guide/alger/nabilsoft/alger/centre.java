package com.guide.alger.nabilsoft.alger;

public class centre {


        String adr;
        String desc;
        float deux;
        String email;
        String fax;
        String name;
        String ouvr;
        String site;
        String tel;
        float un;

        public centre(float un, float deux, String name, String desc, String ouvr, String adr, String tel, String fax, String email, String site) {
            this.name = name;
            this.un = un;
            this.deux = deux;
            this.desc = desc;
            this.ouvr = ouvr;
            this.adr = adr;
            this.tel = tel;
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

        public void setOuvr(String ouvr) {
            this.ouvr = ouvr;
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

        public String getOuvr() {
            return this.ouvr;
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

        public String getEmail() {
            return this.email;
        }

        public String getSite() {
            return this.site;
        }

}

