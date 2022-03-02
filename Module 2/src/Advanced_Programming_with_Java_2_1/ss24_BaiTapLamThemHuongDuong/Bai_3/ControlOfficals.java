package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_3;

import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_1.Candidate;
import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_3.Service.OfficalsService;
import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_3.Service.OfficalsServiceIplm;

import java.util.Scanner;

public class ControlOfficals {
    public static void main(String[] args) {
        Officals[] officals = null;
        OfficalsService officalsService = new OfficalsServiceIplm();
        Scanner input = new Scanner(System.in);

        int select = 0;
        officals = officalsService.findAll();

        do {
            System.out.println("--Cadicate Menu--");
            System.out.println("1. List all");
            System.out.println("2. Add new");
            System.out.println("3. Count female");
            System.out.println("4. List IT");
            System.out.println("9. Exit");

            select = Integer.parseInt(input.nextLine());
            switch (select) {
                case 1:

                    for (Officals officalss : officals) {
                        if(officalss == null){
                            break;
                        }
                        System.out.println(officalss);
                    }
                    break;
                case 2:
                    System.out.print("Input id: ");
                    int id = Integer.parseInt(input.nextLine());
                    System.out.print("Input name: ");
                    String name = input.nextLine();
                    System.out.print("Input sex: ");
                    String sex = input.nextLine();
                    System.out.print("Input address: ");
                    String address = input.nextLine();
                    System.out.print("Input dateOfBirth: ");
                    String dateOfBirth = input.nextLine();
                    System.out.print("Input specicialize: ");
                    String specicialize = input.nextLine();
                    System.out.print("Input level: ");
                    String level = input.nextLine();
                    System.out.print("Input coefficientsSalary: ");
                    double coefficientsSalary = Double.parseDouble(input.nextLine());
                    System.out.print("Input allowance: ");
                    double allowance = Double.parseDouble(input.nextLine());

                    Officals officalsNew = new Officals(id, name, sex, address, dateOfBirth, specicialize, level, coefficientsSalary, allowance);
                    officalsService.add(officalsNew);
                    break;
                case 3:
                    System.out.println("Input Sex: ");

                    officalsService.femaleCount();
                    break;
                case 4:
                    System.out.println("Input specicialize: ");

                    officalsService.listIt();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("input err!");
            }
        }
        while (select != 9);


    }

    }


