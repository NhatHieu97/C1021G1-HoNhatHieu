package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_2;

import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_2.Service.StudentService;
import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_2.Service.StudentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {
//        Student[] studentList = null;
        StudentService studentService = new StudentServiceImpl();
        Scanner scanner = new Scanner(System.in);

        int select = 0;
        do {
            System.out.println("--Student Menu--");
            System.out.println("1. Print List all");
            System.out.println("2. Add new");
            System.out.println("3. Remove");
            System.out.println("4. RemoveIndex");
            System.out.println("5. SearchName");
            System.out.println("6. Sort List All");
            System.out.println("9. Exit");

            select = Integer.parseInt(scanner.nextLine());

            switch (select) {
                case 1:
//                    studentList = studentService.findAll();
//                    for (Student students : studentList) {
//                        if (students == null){
//                            continue;
//                        }
//                        System.out.println(students);
//                    }
                    List<Student> studentList = studentService.findAll();
                    for (Student student: studentList){
                        System.out.println(student.toString());
                    }

                    break;
                case 2:
                    System.out.print("Input id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Input name: ");
                    String name = scanner.nextLine();
                    System.out.print("Input dateOfBirth: ");
                    String dateOfBirth = scanner.nextLine();
                    System.out.print("Input sex: ");
                    String sex = scanner.nextLine();
                    System.out.print("Input nameClass: ");
                    String nameClass = scanner.nextLine();
                    System.out.print("Input nameCourse: ");
                    String nameCourse = scanner.nextLine();
                    Student studentNew = new Student(id, name, dateOfBirth, sex, nameClass, nameCourse);
                    studentService.add(studentNew);
                    break;
                case 3:
                    System.out.print("Input id: ");
                    int idRemove = Integer.parseInt(scanner.nextLine());
                    studentService.remove(idRemove);
                    break;
                case 4:
                    System.out.print("Input index: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    studentService.removeIndex(index);
                    break;
                case 5:
                    System.out.print("Input searchName: ");
                    String searchName =scanner.nextLine();
                    studentService.search(searchName);
                    break;
                case 6:
//                    Arrays.sort(studentService.findAll());
                    break;
                case 9:
                    break;
                default:
                    System.out.println("input err!");
            }

        }while (select != 9);
    }
    }

