package Advanced_Programming_with_Java_2_1.ss10_DSA_Danh_sach.Bai_tap;

public class TestMyList {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
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
    }

    public static void main(String[] args) {
        Student student = new Student(1, "tu");
        Student student1 = new Student(2, "nam");
        Student student2 = new Student(3, "nu");
        Student f = new Student(5, "nu2");

        MyList<Student> studentMyList = new MyList<>();
        MyList<Student> studentMyList1 = new MyList<>();
        studentMyList.add(student);
        studentMyList.add(student1);
        studentMyList.add(student2);
        studentMyList.add(f, 2);
        System.out.println(studentMyList.size());
        System.out.println(studentMyList.get(2).getName());
        for (int i = 0; i < studentMyList.size(); i++) {
            Student student3 = (Student) studentMyList.elements[i];
            System.out.println(student3.getId());
            System.out.println(student3.getName());
        }
        studentMyList1 = studentMyList.clone();
        System.out.println(student.getName());
//        for (int i = 0; i< studentMyList1.size();i++){
//            System.out.println(studentMyList1.get(i).getName());
//        }
    }
}
