package Model.Students;

import GUI.Configuration;

public class ConfigurationStudent extends Student {

    private String address;
    private String PESEL;
    private String tel;
    private String eMail;


    public String getAddress() {
        return address;
    }

    public String getPESEL() {

        return PESEL;
    }

    public String getTel() {

        return tel;
    }

    public String geteMail() {

        return eMail;
    }

    public static final class Builder{

        private String id;
        private String name;
        private String surrname;
        private String address;
        private String PESEL;
        private String tel;
        private String eMail;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder surrname(String surrname){
            this.surrname = surrname;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder PESEL(String PESEL){
            this.PESEL = PESEL;
            return this;
        }

        public Builder tel(String tel){
            this.tel = tel;
            return this;
        }

        public Builder eMail(String eMail){
            this.eMail = eMail;
            return this;
        }

        public ConfigurationStudent build(){
            ConfigurationStudent configurationStudent = new ConfigurationStudent();

            configurationStudent.id = this.id;
            configurationStudent.name = this.name;
            configurationStudent.surrname = this.surrname;
            configurationStudent.address = this.address;
            configurationStudent.PESEL = this.PESEL;
            configurationStudent.tel = this.tel;
            configurationStudent.eMail = this.eMail;

            return configurationStudent;
        }
    }
}
