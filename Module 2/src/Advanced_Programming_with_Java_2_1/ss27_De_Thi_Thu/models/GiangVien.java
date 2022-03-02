package Advanced_Programming_with_Java_2_1.ss27_De_Thi_Thu.models;

public class GiangVien extends Persons {
    private String chuyenMon;

    public GiangVien() {
    }

    public GiangVien(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public GiangVien(String id, String ten, String ngaySinh, String gioiTinh, String chuyenMon) {
        super(id, ten, ngaySinh, gioiTinh);
        this.chuyenMon = chuyenMon;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    @Override
    public String toString() {
        return "GiangVien{" +
                super.toString() +
                ", chuyenMon='" + chuyenMon + '\'' +
                '}';
    }
}

