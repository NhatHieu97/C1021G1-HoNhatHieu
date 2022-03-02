package Advanced_Programming_with_Java_2_1.ss3_Mang_va_phuong_thuc_trong_Java.Bai_tap;

import java.util.Scanner;

public class TinhTongCacSoODuongCheoChinhMaTran {
        public static void main(String[] args) {
            System.out.println("Hiển Thị Tổng Các Số Ở Đường Chéo Chính Ma Trận");

            Scanner input = new Scanner(System.in);
            System.out.print("Enter the number row: ");
            int a = input.nextInt();
            System.out.print("Enter the number columns: ");
            int b = input.nextInt();
            int[][] arr = new int[a][b];

            System.out.println("Enter " + arr.length + " rows and " + arr[0].length + " columns: ");

            for (int row = 0; row < a; row++) {
                for (int columns = 0; columns < b; columns++) {
                    System.out.print("Enter arr" + "[" + row + "]" + "[" + columns + "]: ");
                    arr[row][columns] = input.nextInt();
                }
            }
            for (int row = 0; row < a; row++) {
                for (int columns = 0; columns < b; columns++) {
                    System.out.print(arr[row][columns] + "\t");
                }
                System.out.println();
            }
            int sum = 0;
            for (int row = 0; row < a; row++) {
                for (int columns = 0; columns < b; columns++) {
                    if (row == columns){
                        sum += arr[row][columns];
                    }
                }
            }
            System.out.print("Sum is: " + sum +"\t");
    }
}
