package Advanced_Programming_with_Java_2_1.ss2_Vong_lap_trong_Java.Thuc_hanh;

import java.util.Scanner;

public class SoNguyenTo {
    public static void main(String[] args) {
        System.out.println("Hiển thị số nguyên tố: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("Là số nguyên tố");
        } else {
            System.out.println("Không phải số nguyên tố");
        }
    }

}
