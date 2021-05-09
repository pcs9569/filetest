package fishbun.fishbunspring.domain;

public class Store {
    private Integer sto_id;
    private String sto_name;
    private String sto_picture;
    private String sto_detail_option;
    private Double sto_lat;
    private Double sto_lon;

    public Integer getSto_id() {
        return sto_id;
    }

    public void setSto_id(Integer sto_id) {
        this.sto_id = sto_id;
    }

    public String getSto_name() {
        return sto_name;
    }

    public void setSto_name(String sto_name) {
        this.sto_name = sto_name;
    }

    public String getSto_picture() {
        return sto_picture;
    }

    public void setSto_picture(String sto_picture) {
        this.sto_picture = sto_picture;
    }

    public String getSto_detail_option() {
        return sto_detail_option;
    }

    public void setSto_detail_option(String sto_detail_option) {
        this.sto_detail_option = sto_detail_option;
    }

    public Double getSto_lat() {
        return sto_lat;
    }

    public void setSto_lat(Double sto_lat) {
        this.sto_lat = sto_lat;
    }

    public Double getSto_lon() {
        return sto_lon;
    }

    public void setSto_lon(Double sto_lon) {
        this.sto_lon = sto_lon;
    }

    @Override
    public String toString() {
        return "Store{" +
                "sto_id=" + sto_id +
                ", sto_name='" + sto_name + '\'' +
                ", sto_picture='" + sto_picture + '\'' +
                ", sto_detail_option='" + sto_detail_option + '\'' +
                ", sto_lat=" + sto_lat +
                ", sto_lon=" + sto_lon +
                '}';
    }
}
