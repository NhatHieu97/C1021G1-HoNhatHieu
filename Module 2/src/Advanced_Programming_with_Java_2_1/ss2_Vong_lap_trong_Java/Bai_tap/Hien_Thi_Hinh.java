package Advanced_Programming_with_Java_2_1.ss2_Vong_lap_trong_Java.Bai_tap;

import java.util.Scanner;

public class Hien_Thi_Hinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Draw the rectangle");
        System.out.println("2. Draw the botton-left triangle ");
        System.out.println("3. Draw the top-left triangle ");
        System.out.println("4. Draw the isosceles triangle");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");

        while (true) {
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter a:");
                    int a = input.nextInt();
                    System.out.println("Enter b:");
                    int b = input.nextInt();
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 1; j <= 7; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Enter n:");
                    int n = input.nextInt();
                    for (int i = 1; i < n; i++) {
                        for (int j = 1; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Enter c:");
                    int c = input.nextInt();
                    for (int i = 0; i < c; i++) {
                        for (int j = c; j > i; j--) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("Enter d:");
                    int d = input.nextInt();
                    for (int i = 1; i <= d; i++) {
                        for (int j = d; j > i; j--) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= i * 2 - 1; k++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
                    break;
            }
        }
    }
}
