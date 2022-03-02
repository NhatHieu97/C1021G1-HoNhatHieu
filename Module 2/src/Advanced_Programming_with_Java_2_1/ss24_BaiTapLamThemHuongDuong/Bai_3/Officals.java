package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_3;

public class Officals {
    private int id;
    private String name;
    private String sex;
    private String address;
    private String dateOfBirth;
    private String specicialize;
    private String level;
    private double coefficientsSalary;
    private double allowance;

    public Officals(int id, String name, String sex, String address,
                    String dateOfBirth, String specicialize, String level,
                    double coefficientsSalary, double allowance) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.specicialize = specicialize;
        this.level = level;
        this.coefficientsSalary = coefficientsSalary;
        this.allowance = allowance;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSpecicialize() {
        return specicialize;
    }

    public void setSpecicialize(String specicialize) {
        this.specicialize = specicialize;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double realField(){
        return (getCoefficientsSalary() + getAllowance()) * 450000;
    }

    @Override
    public String toString() {
        return "Officals{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", specicialize='" + specicialize + '\'' +
                ", level='" + level + '\'' +
                ", coefficientsSalary=" + coefficientsSalary +
                ", allowance=" + allowance +
                ", realField= " + realField() +
                '}';
    }
}
