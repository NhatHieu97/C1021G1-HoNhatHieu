package Advanced_Programming_with_Java_2_1.ss1_Introduction_to_Java.Bai_tap;

import java.util.Scanner;

public class HienThiSoNguyenToNhoHon100 {
    public static boolean kiemTraSoNguyento(int number) {
        if (number < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(number);
        for (int i = 2; i <= squareRoot; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập n = ");
        int number = scanner.nextInt();
        System.out.printf("Tất cả các số nguyên tố nhỏ hơn %d là: \n", number);
        if (number >= 2) {
            System.out.println(2);
        }
        for (int j = 3; j < number; j += 2) {
            if (kiemTraSoNguyento(j)) {
                System.out.println(j);
            }
        }
    }



}
