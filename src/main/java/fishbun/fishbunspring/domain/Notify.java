package fishbun.fishbunspring.domain;

public class Notify {
    private Integer noti_id;
    private Integer sto_id;
    private String u_email;
    private String noti_content;
    private String reg_date;
    private Integer noti_type;

    public Integer getNoti_id() {
        return noti_id;
    }

    public void setNoti_id(Integer noti_id) {
        this.noti_id = noti_id;
    }

    public Integer getSto_id() {
        return sto_id;
    }

    public void setSto_id(Integer sto_id) {
        this.sto_id = sto_id;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getNoti_content() {
        return noti_content;
    }

    public void setNoti_content(String noti_content) {
        this.noti_content = noti_content;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public Integer getNoti_type() {
        return noti_type;
    }

    public void setNoti_type(Integer noti_type) {
        this.noti_type = noti_type;
    }

    @Override
    public String toString() {
        return "Notify{" +
                "noti_id=" + noti_id +
                ", sto_id=" + sto_id +
                ", u_email='" + u_email + '\'' +
                ", noti_content='" + noti_content + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", noti_type=" + noti_type +
                '}';
    }
}
