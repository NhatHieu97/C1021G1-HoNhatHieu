package Advanced_Programming_with_Java_2_1.ss2_Vong_lap_trong_Java.Bai_tap;

import java.util.Scanner;

public class HienThi20SoNguyenTo {
    public static void main(String[] args) {
        System.out.println("Hiển thị 20 số nguyên tố:");

        Scanner input = new Scanner(System.in);
        int numbers = input.nextInt();
        int count = 0;
        int n = 2;
        boolean check;
        while (count < numbers){
            check = true;
            for (int i = 2; i <= Math.sqrt(n); i++ ){
                if (n % i == 0){
                    check = false;
                    break;
                }
            } if (check){
                System.out.println(n);
                count++;
            }
            n++;
        }


    }
}
