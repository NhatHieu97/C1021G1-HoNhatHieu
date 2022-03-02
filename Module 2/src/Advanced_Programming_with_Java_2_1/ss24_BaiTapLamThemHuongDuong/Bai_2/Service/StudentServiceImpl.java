package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_2.Service;

import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_2.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    //    private static Student[] studentList = new Student[100];
    public static List<Student> studentList = new ArrayList<>();
    static {
        Student student1 = new Student(4, "Đạt", "01/02/2003","Male" , "C1021G1", "C10");
        Student student2 = new Student(5, "Linh", "08/05/1991","Female" , "C0921G1", "C09");
        Student student3 = new Student(3, "Tấn", "12/03/2001","Male" , "C0721G1", "C07");
        Student student4 = new Student(1, "Hoa", "09/12/1997","Female" , "C1021G1", "C10");
        Student student5 = new Student(2, "Trọng", "01/02/1998","Male" , "C0921G1", "C09");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
    }
//    static {
//        studentList[0] = new Student(4, "Đạt", "01/02/2003","Male" , "C1021G1", "C10");
//        studentList[1] = new Student(5, "Linh", "08/05/1991","Female" , "C0921G1", "C09");
//        studentList[2] = new Student(3, "Tấn", "12/03/2001","Male" , "C0721G1", "C07");
//        studentList[3] = new Student(1, "Hoa", "09/12/1997","Female" , "C1021G1", "C10");
//        studentList[4] = new Student(2, "Trọng", "01/02/1998","Male" , "C0921G1", "C09");
//
//    }
//    @Override

    public void add(Student student) {
//        Student[] newStudentList = new Student[studentList.length + 1];
//        newStudentList[newStudentList.length - 1] = student;
//        for (int i = 0; i < studentList.length; i++) {
//            newStudentList[i] = studentList[i];
//        }
//        studentList = newStudentList;

        studentList.add(student);
    }






    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(studentList.get(i));
            }
        }
    }

    @Override
    public void removeIndex(int index) {
        studentList.remove(index - 1);
    }

    @Override
    public void search(String mssv) {
        for (int i = 0; i < studentList.size(); i++) {
            if (isNumeric(mssv)) {
                if (studentList.get(i).getId() == (Integer.parseInt(mssv))) {
                    System.out.println(studentList.get(i));
                }
            } else {
                if (studentList.get(i).getName().equals(mssv)) {
                    System.out.println(studentList.get(i));
                }
            }
        }
    }

    public static boolean isNumeric(CharSequence kiTu) {
        if (kiTu.equals(null)) {
            return false;
        }
        for (int i = 0; i < kiTu.length(); i++) {
            if (!Character.isDigit(kiTu.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
