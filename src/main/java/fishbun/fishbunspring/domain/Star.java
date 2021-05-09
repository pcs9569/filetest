package fishbun.fishbunspring.domain;

public class Star {
    private Integer star_id;
    private Integer sto_id;
    private String u_email;
    private Integer star_point;

    public Integer getStar_id() {
        return star_id;
    }

    public void setStar_id(Integer star_id) {
        this.star_id = star_id;
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

    public Integer getStar_point() {
        return star_point;
    }

    public void setStar_point(Integer star_point) {
        this.star_point = star_point;
    }
}
