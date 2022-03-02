package Advanced_Programming_with_Java_2_1.ss5_Access_modifier_static_method_static_property.Bai_tap;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public Student (){
    }
    private Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setClasses(String classes) {
        this.classes = classes;
    }
    public String getClasses() {
        return classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}

class HocSinh{
    public static void main(String[] args) {
        Student student1 = new Student();
//        student1.setName("hieu");
//        student1.setClasses("C10");

        System.out.println(student1.toString());

    }

}
