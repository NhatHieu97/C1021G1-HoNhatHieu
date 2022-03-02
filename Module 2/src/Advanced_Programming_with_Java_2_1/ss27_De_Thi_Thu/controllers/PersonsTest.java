package Advanced_Programming_with_Java_2_1.ss27_De_Thi_Thu.controllers;

import Advanced_Programming_with_Java_2_1.ss26_De_thi_09.service.DienThoaiImpl;
import Advanced_Programming_with_Java_2_1.ss27_De_Thi_Thu.service.PersonsImpl;

import java.util.Scanner;

public class PersonsTest {
    public static final String ALIGNMENT = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    public static final String ALIGNMENT1 = "\t\t\t\t\t\t\t\t\t\t\t\t\t";
    static Scanner scanner = new Scanner(System.in);
    static int choice;
    static boolean checkChoice;

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        PersonsImpl persons = new PersonsImpl();
        do {
            checkChoice = false;
            System.out.println(ALIGNMENT1 + "(^_^) Menu danh sách Person (^_^)");
            System.out.println(ALIGNMENT + "1. Thêm mới");
            System.out.println(ALIGNMENT + "2. Xóa");
            System.out.println(ALIGNMENT + "3. Xem danh sách Person");
            System.out.println(ALIGNMENT + "4. Tìm Kiếm");
            System.out.println(ALIGNMENT + "5. Thoát");
            System.out.println();
            System.out.println(ALIGNMENT + "(^_^)___________(^_^)");
            System.out.println(ALIGNMENT + "Vui lòng nhập sự lựa chọn của bạn !!!");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(ALIGNMENT + "Vui lòng kiểm tra lại format danh sách !!!");
                checkChoice = true;
                continue;
            }

            switch (choice) {
                case 1:
                    do {
                        checkChoice = false;
                        System.out.println(ALIGNMENT + "1. Thêm mới học viên");
                        System.out.println(ALIGNMENT + "2. Thêm mới giảng viên");
                        System.out.println(ALIGNMENT + "3. Quay lại thanh menu");
                        System.out.println(ALIGNMENT + "(^_^)___________(^_^)");
                        System.out.println(ALIGNMENT + "Vui lòng nhập sự lựa chọn của bạn !!!");
                        try {
                            choice = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println(ALIGNMENT + "Vui lòng kiểm tra lại format danh sách !!!");
                            checkChoice = true;
                            continue;
                        }
                        switch (choice) {
                            case 1:
                                persons.themMoi(1);
                                checkChoice = true;
                                continue;
                            case 2:
                                persons.themMoi(2);
                                checkChoice = true;
                                continue;
                            case 3:
                                displayMainMenu();
                                break;

                            default:
                                System.out.println(ALIGNMENT + "Vui lòng kiểm tra lại danh sách !!!");
                                checkChoice = true;
                                continue;
                        }
                    } while (checkChoice);
                    checkChoice = true;
                    continue;
                case 2:
                    persons.xoa();
                    checkChoice = true;
                    continue;
                case 3:
                    persons.danhSachPersons();
                    checkChoice = true;
                    continue;
                case 4:
                    persons.timKiem();
                    checkChoice = true;
                    continue;
                case 5:
                    System.exit(0);

                default:
                    System.out.println(ALIGNMENT + "look at the list carefully");
                    checkChoice = true;
                    continue;
            }
        } while (checkChoice);
    }
}
