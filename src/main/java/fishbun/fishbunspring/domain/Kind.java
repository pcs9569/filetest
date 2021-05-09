package fishbun.fishbunspring.domain;

public class Kind {
    private Integer kind_id;
    private Integer sto_id;
    private String kind_article;

    public Integer getKind_id() {
        return kind_id;
    }

    public void setKind_id(Integer kind_id) {
        this.kind_id = kind_id;
    }

    public Integer getSto_id() {
        return sto_id;
    }

    public void setSto_id(Integer sto_id) {
        this.sto_id = sto_id;
    }

    public String getKind_article() {
        return kind_article;
    }

    public void setKind_article(String kind_article) {
        this.kind_article = kind_article;
    }

    @Override
    public String toString() {
        return "Kind{" +
                "kind_id=" + kind_id +
                ", sto_id=" + sto_id +
                ", kind='" + kind_article + '\'' +
                '}';
    }
}
