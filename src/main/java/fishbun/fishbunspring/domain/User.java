package fishbun.fishbunspring.domain;

public class User {
    private String u_email;
    private String u_name;
    private String u_pw;
    private String u_date;
    private Integer u_level;

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pw() {
        return u_pw;
    }

    public void setU_pw(String u_pw) {
        this.u_pw = u_pw;
    }

    public String getU_date() {
        return u_date;
    }

    public void setU_date(String u_date) {
        this.u_date = u_date;
    }

    public Integer getU_level() {
        return u_level;
    }

    public void setU_level(Integer u_level) {
        this.u_level = u_level;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_email='" + u_email + '\'' +
                ", u_name='" + u_name + '\'' +
                ", u_pw='" + u_pw + '\'' +
                ", u_date='" + u_date + '\'' +
                ", u_level=" + u_level +
                '}';
    }
}
