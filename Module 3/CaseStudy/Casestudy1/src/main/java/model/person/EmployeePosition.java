package model.person;

public class EmployeePosition {
    private int idPosition;
    private String namePosition;

    public EmployeePosition() {
    }

    public EmployeePosition(int idPosition, String namePosition) {
        this.idPosition = idPosition;
        this.namePosition = namePosition;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }
}
