package Advanced_Programming_with_Java_2_1.ss28_De_Thi_Module_2.controllers;


import Advanced_Programming_with_Java_2_1.ss28_De_Thi_Module_2.service.SanPhamImpl;

import java.util.Scanner;

public class SanPhamTest {
    public static final String ALIGNMENT = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    public static final String ALIGNMENT1 = "\t\t\t\t\t\t\t\t\t\t\t\t\t";
    static Scanner scanner= new Scanner(System.in);
    static int choice;
    static boolean checkChoice;
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu(){
        SanPhamImpl sanPham = new SanPhamImpl();
        do{
            checkChoice = false;
            System.out.println(ALIGNMENT1 + "(^_^) Menu danh sách sản phẩm (^_^)");
            System.out.println(ALIGNMENT + "1. Thêm mới");
            System.out.println(ALIGNMENT + "2. Xóa");
            System.out.println(ALIGNMENT + "3. Xem danh sách sản phẩm");
            System.out.println(ALIGNMENT + "4. Tìm Kiếm");
            System.out.println(ALIGNMENT + "5. Thoát");
            System.out.println();
            System.out.println(ALIGNMENT + "(^_^)___________(^_^)");
            System.out.println(ALIGNMENT + "Vui lòng nhập sự lựa chọn của bạn !!!");

            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println(ALIGNMENT +"Vui lòng kiểm tra lại format danh sách !!!");
                checkChoice = true;
                continue;
            }

            switch (choice){
                case 1:
                    do {
                        checkChoice = false;
                        System.out.println(ALIGNMENT +"1. Thêm mới sản phảm nhập khẩu");
                        System.out.println(ALIGNMENT +"2. Thêm mới sản phẩm xuất khẩu");
                        System.out.println(ALIGNMENT +"3. Quay lại thanh menu");
                        System.out.println(ALIGNMENT +"(^_^)___________(^_^)");
                        System.out.println(ALIGNMENT +"Vui lòng nhập sự lựa chọn của bạn !!!");
                        try {
                            choice = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println(ALIGNMENT + "Vui lòng kiểm tra lại format danh sách !!!");
                            checkChoice = true;
                            continue;
                        }
                        switch(choice){
                            case 1:
                                sanPham.themMoi(1);
                                checkChoice = true;
                                continue;
                            case 2:
                                sanPham.themMoi(2);
                                checkChoice = true;
                                continue;
                            case 3:
                                displayMainMenu();
                                break;

                            default:
                                System.out.println(ALIGNMENT +"Vui lòng kiểm tra lại danh sách !!!");
                                checkChoice = true;
                                continue;
                        }
                    }while (checkChoice);
                    checkChoice = true;
                    continue;
                case 2:
                    sanPham.xoa();
                    checkChoice = true;
                    continue;
                case 3:
                    sanPham.danhSachSanPham();
                    checkChoice = true;
                    continue;
                case 4:
                    sanPham.timKiem();
                    checkChoice = true;
                    continue;
                case 5:
                    System.exit(0);

                default:
                    System.out.println(ALIGNMENT +"look at the list carefully");
                    checkChoice = true;
                    continue;
            }
        }while(checkChoice);
    }

}
