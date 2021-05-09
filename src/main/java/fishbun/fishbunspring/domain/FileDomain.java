package fishbun.fishbunspring.domain;

public class FileDomain {
    private int file_id;
    private int sto_id;
    private String file_origin_name;
    private String file_save_name;
    private long file_size;
    private String file_delete_yn;
    private String file_reg_date;
    private String file_del_date;
//
//    public FileDomain(int file_id, int sto_id, String file_origin_name, String file_save_name, long file_size, String file_delete_yn, String file_reg_date, String file_del_date) {
//        this.file_id = file_id;
//        this.sto_id = sto_id;
//        this.file_origin_name = file_origin_name;
//        this.file_save_name = file_save_name;
//        this.file_size = file_size;
//        this.file_delete_yn = file_delete_yn;
//        this.file_reg_date = file_reg_date;
//        this.file_del_date = file_del_date;
//    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public int getSto_id() {
        return sto_id;
    }

    public void setSto_id(int sto_id) {
        this.sto_id = sto_id;
    }

    public String getFile_origin_name() {
        return file_origin_name;
    }

    public void setFile_origin_name(String file_origin_name) {
        this.file_origin_name = file_origin_name;
    }

    public String getFile_save_name() {
        return file_save_name;
    }

    public void setFile_save_name(String file_save_name) {
        this.file_save_name = file_save_name;
    }

    public long getFile_size() {
        return file_size;
    }

    public void setFile_size(long file_size) {
        this.file_size = file_size;
    }

    public String getFile_delete_yn() {
        return file_delete_yn;
    }

    public void setFile_delete_yn(String file_delete_yn) {
        this.file_delete_yn = file_delete_yn;
    }

    public String getFile_reg_date() {
        return file_reg_date;
    }

    public void setFile_reg_date(String file_reg_date) {
        this.file_reg_date = file_reg_date;
    }

    public String getFile_del_date() {
        return file_del_date;
    }

    public void setFile_del_date(String file_del_date) {
        this.file_del_date = file_del_date;
    }
}
