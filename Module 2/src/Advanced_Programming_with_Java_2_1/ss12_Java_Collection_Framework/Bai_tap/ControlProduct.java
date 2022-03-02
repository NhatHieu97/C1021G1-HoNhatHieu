package Advanced_Programming_with_Java_2_1.ss12_Java_Collection_Framework.Bai_tap;

import Advanced_Programming_with_Java_2_1.ss12_Java_Collection_Framework.Bai_tap.Service.IService;
import Advanced_Programming_with_Java_2_1.ss12_Java_Collection_Framework.Bai_tap.Service.ServiceIpl;

import java.util.Scanner;

public class ControlProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IService iService = new ServiceIpl();

        int select = 0;
        do {
            System.out.println("--Product Menu--");
            System.out.println("1. Print List all");
            System.out.println("2. Add new");
            System.out.println("3. Remove");
            System.out.println("4. SearchName");
            System.out.println("5. Sort incresePr");
            System.out.println("6. Sort decresePr");
            System.out.println("9. Exit");
            select = Integer.parseInt(scanner.nextLine());

            switch (select) {
                case 1:
                    iService.findAll();
                    break;
                case 2:
                    iService.add();
                    break;
                case 3:
                    iService.remove();
                    break;
                case 4:
                    iService.search();
                    break;
                case 5:
                    iService.sortIncrease();
                    break;
                case 6:
                    iService.sortDcrease();
                    break;

                default:
                    System.out.println("input err!");


            }

        }while (select != 9);
    }


}
