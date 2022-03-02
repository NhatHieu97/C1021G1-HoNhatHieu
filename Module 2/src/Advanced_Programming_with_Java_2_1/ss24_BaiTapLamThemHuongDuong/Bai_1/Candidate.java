package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_1;

public class Candidate {
    private int id;
    private String name;
    private double toan;
    private double van;
    private double anh;

    public Candidate(int id, String name, double toan, double van, double anh) {
        this.id = id;
        this.name = name;
        this.toan = toan;
        this.van = van;
        this.anh = anh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getToan() {
        return toan;
    }

    public void setToan(double toan) {
        this.toan = toan;
    }

    public double getVan() {
        return van;
    }

    public void setVan(double van) {
        this.van = van;
    }

    public double getAnh() {
        return anh;
    }

    public void setAnh(double anh) {
        this.anh = anh;
    }

    public double diemThi(){
        return getAnh() + getToan() + getVan();
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", toan=" + toan +
                ", van=" + van +
                ", anh=" + anh +
                '}';
    }
}
