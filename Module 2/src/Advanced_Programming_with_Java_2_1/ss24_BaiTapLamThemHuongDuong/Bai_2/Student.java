package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_2;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private String dateOfBirth;
    private String sex;
    private String nameClass;
    private String nameCourse;

    public Student(int id, String name, String dateOfBirth, String sex, String nameClass, String nameCourse) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.nameClass = nameClass;
        this.nameCourse = nameCourse;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", sex='" + sex + '\'' +
                ", nameClass='" + nameClass + '\'' +
                ", nameCourse='" + nameCourse + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return  getId() - o.getId();
    }
}
