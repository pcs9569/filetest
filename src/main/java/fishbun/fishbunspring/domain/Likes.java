package fishbun.fishbunspring.domain;

public class Likes {
    private Integer likes_id;
    private Integer sto_id;
    private String u_email;
    private Integer likes_press;

    public Integer getLikes_id() {
        return likes_id;
    }

    public void setLikes_id(Integer likes_id) {
        this.likes_id = likes_id;
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

    public Integer getLikes_press() {
        return likes_press;
    }

    public void setLikes_press(Integer likes_press) {
        this.likes_press = likes_press;
    }

    @Override
    public String toString() {
        return "Likes{" +
                "likes_id=" + likes_id +
                ", sto_id=" + sto_id +
                ", u_email='" + u_email + '\'' +
                ", likes_press=" + likes_press +
                '}';
    }
}


