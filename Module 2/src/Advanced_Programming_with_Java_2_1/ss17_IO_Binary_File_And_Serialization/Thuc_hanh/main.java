package Advanced_Programming_with_Java_2_1.ss17_IO_Binary_File_And_Serialization.Thuc_hanh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static final String STUDENTPATH = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss17_IO_Binary_File_And_Serialization\\Thuc_hanh\\student.txt";

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile(STUDENTPATH, students);
        List<Student> studentDataFromFile = readDataFromFile(STUDENTPATH);
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }
}
