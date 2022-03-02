package Advanced_Programming_with_Java_2_1.ss15_Xu_li_ngoai_le_And_Debug.Bai_tap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) throws Exception {
        Triangle triangle = new Triangle();
        Scanner scanner = new Scanner(System.in);
        boolean check = true;

        int a = 0, b = 0, c = 0;
        do {
            check = false;
            try {
                System.out.println("Nhập cạnh a: ");
                a = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập cạnh b: ");
                b = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập cạnh c: ");
                c = Integer.parseInt(scanner.nextLine());

            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
                continue;
            }
            try {
                triangle.caculate(a, b, c);

            }catch (IllegalTriangleException e){
                if (e.getA() == 1){
                    System.out.println(e.getMessage());
                }else {
                    System.out.println(e.getMessage1());
                }
                check = true;
            }
        }while (check);

    }

    public void caculate(int a, int b, int c) throws IllegalTriangleException {
            if (a < 0 || b < 0 || c < 0) {
                throw new IllegalTriangleException(1);
            }else if ((a + b) <= c || (a + c) <= b || (b + c) <= a ){
                throw new IllegalTriangleException(2);
            }else {
                System.out.println("Triangle is" + " a = " + a +"; b = " + b + "; c = " +  c);
            }

        }

    }

