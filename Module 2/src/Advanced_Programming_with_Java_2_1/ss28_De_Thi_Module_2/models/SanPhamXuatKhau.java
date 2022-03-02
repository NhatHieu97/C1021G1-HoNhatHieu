package Advanced_Programming_with_Java_2_1.ss28_De_Thi_Module_2.models;

public class SanPhamXuatKhau extends SanPham {
    private double giaXuatKhau;
    private String quocGiaNhapSanPham;

    public SanPhamXuatKhau() {
    }

    public SanPhamXuatKhau(String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat) {
        super(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
    }

    public SanPhamXuatKhau(double giaXuatKhau, String quocGiaNhapSanPham) {
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    public SanPhamXuatKhau(String maSanPham, String tenSanPham, double giaBan, int soLuong, String nhaSanXuat, double giaXuatKhau, String quocGiaNhapSanPham) {
        super(maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    public double getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(double giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhapSanPham() {
        return quocGiaNhapSanPham;
    }

    public void setQuocGiaNhapSanPham(String quocGiaNhapSanPham) {
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    @Override
    public String toString() {
        return "SanPhamXuatKhau{" +
                super.toString() +
                ", giaXuatKhau=" + giaXuatKhau +
                ", quocGiaNhapSanPham='" + quocGiaNhapSanPham + '\'' +
                '}';
    }
}
