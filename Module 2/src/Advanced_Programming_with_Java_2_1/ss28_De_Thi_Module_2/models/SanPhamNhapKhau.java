package Advanced_Programming_with_Java_2_1.ss28_De_Thi_Module_2.models;

public class SanPhamNhapKhau extends SanPham {
    private double giaNhapKhau;
    private String tinhThanhNhap;
    private double thueNhapKhau;

    public SanPhamNhapKhau() {
    }

    public SanPhamNhapKhau(double giaNhapKhau, String tinhThanhNhap, double thueNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public SanPhamNhapKhau(String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat, double giaNhapKhau, String tinhThanhNhap, double thueNhapKhau) {
        super(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public double getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(double giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public double getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(double thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return "SanPhamNhapKhau{" +
                super.toString() +
                " ,giaNhapKhau=" + giaNhapKhau +
                ", tinhThanhNhap='" + tinhThanhNhap + '\'' +
                ", thueNhapKhau=" + thueNhapKhau +
                '}';
    }
}
