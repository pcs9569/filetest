package fishbun.fishbunspring.domain;

public class Review {
    private Integer rev_id;
    private Integer sto_id;
    private String u_email;
    private String rev_content;
    private String rev_reg_date;
    private String rev_mod_date;

    public Integer getRev_id() {
        return rev_id;
    }

    public void setRev_id(Integer rev_id) {
        this.rev_id = rev_id;
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

    public String getRev_content() {
        return rev_content;
    }

    public void setRev_content(String rev_content) {
        this.rev_content = rev_content;
    }

    public String getRev_reg_date() {
        return rev_reg_date;
    }

    public void setRev_reg_date(String rev_reg_date) {
        this.rev_reg_date = rev_reg_date;
    }

    public String getRev_mod_date() {
        return rev_mod_date;
    }

    public void setRev_mod_date(String rev_mod_date) {
        this.rev_mod_date = rev_mod_date;
    }

    @Override
    public String toString() {
        return "review{" +
                "rev_id=" + rev_id +
                ", sto_id=" + sto_id +
                ", u_email='" + u_email + '\'' +
                ", rev_content='" + rev_content + '\'' +
                ", rev_reg_date='" + rev_reg_date + '\'' +
                ", rev_mod_date='" + rev_mod_date + '\'' +
                '}';
    }
}
