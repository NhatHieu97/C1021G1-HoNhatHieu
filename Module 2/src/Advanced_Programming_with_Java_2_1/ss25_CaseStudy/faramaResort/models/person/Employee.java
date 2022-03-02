package Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.person;

public class Employee extends Person {
    private String quatification;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String id, String name, String dayOfBirth, String gender, String identityCardNumber, String numberPhone, String email, String quatification, String position, double salary) {
        super(id, name, dayOfBirth, gender, identityCardNumber, numberPhone, email);
        this.quatification = quatification;
        this.position = position;
        this.salary = salary;
    }

    public String getQuatification() {
        return quatification;
    }

    public void setQuatification(String quatification) {
        this.quatification = quatification;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                ", quatification='" + quatification + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
