package model.person;

public class Employee extends Person {
    private String educationDegree;
    private String position;
    private String division;
    private String userName;
    private int idPosition;
    private int idDivision;
    private int idEducationDegree;
    private int salary;

    public Employee() {
    }

    public Employee(String educationDegree, String position, String division, String userName, int idPosition, int idDivision, int idEducationDegree, int salary) {
        this.educationDegree = educationDegree;
        this.position = position;
        this.division = division;
        this.userName = userName;
        this.idPosition = idPosition;
        this.idDivision = idDivision;
        this.idEducationDegree = idEducationDegree;
        this.salary = salary;
    }

    public Employee(int id, String name, String birthday, String idCard, String phone, String email, String address, String code,
                    String educationDegree, String position, String division, String userName, int idPosition, int idDivision, int idEducationDegree, int salary) {
        super(id, name, birthday, idCard, phone, email, address, code);
        this.educationDegree = educationDegree;
        this.position = position;
        this.division = division;
        this.userName = userName;
        this.idPosition = idPosition;
        this.idDivision = idDivision;
        this.idEducationDegree = idEducationDegree;
        this.salary = salary;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(int idDivision) {
        this.idDivision = idDivision;
    }

    public int getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(int idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
