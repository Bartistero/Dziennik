package Model.Students;

public class ConfigurationStudent extends Student {

    private String adress;
    private String PESEL;
    private String tel;
    private String eMail;

    public ConfigurationStudent(String id, String name, String surrname) {
        super(id, name, surrname);
    }

    public String getAdress() {
        return adress;
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
}
