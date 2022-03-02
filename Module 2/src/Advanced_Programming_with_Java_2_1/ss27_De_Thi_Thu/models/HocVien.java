package Advanced_Programming_with_Java_2_1.ss27_De_Thi_Thu.models;

public class HocVien extends Persons {
    private String lop;
    private double diemSo;

    public HocVien() {
    }

    public HocVien(String lop, double diemSo) {
        this.lop = lop;
        this.diemSo = diemSo;
    }

    public HocVien(String id, String ten, String ngaySinh, String gioiTinh, String lop, double diemSo) {
        super(id, ten, ngaySinh, gioiTinh);
        this.lop = lop;
        this.diemSo = diemSo;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public double getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(double diemSo) {
        this.diemSo = diemSo;
    }

    @Override
    public String toString() {
        return "HocVien{" +
                super.toString() +
                ", lop='" + lop + '\'' +
                ", diemSo=" + diemSo +
                '}';
    }
}
