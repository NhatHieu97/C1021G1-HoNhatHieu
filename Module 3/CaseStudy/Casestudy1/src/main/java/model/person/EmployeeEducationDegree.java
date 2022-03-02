package model.person;

public class EmployeeEducationDegree {
    private int idEducationDegree;
    private String nameEducationDegree;

    public EmployeeEducationDegree() {
    }

    public EmployeeEducationDegree(int idEducationDegree, String nameEducationDegree) {
        this.idEducationDegree = idEducationDegree;
        this.nameEducationDegree = nameEducationDegree;
    }

    public int getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(int idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    public String getNameEducationDegree() {
        return nameEducationDegree;
    }

    public void setNameEducationDegree(String nameEducationDegree) {
        this.nameEducationDegree = nameEducationDegree;
    }
}
