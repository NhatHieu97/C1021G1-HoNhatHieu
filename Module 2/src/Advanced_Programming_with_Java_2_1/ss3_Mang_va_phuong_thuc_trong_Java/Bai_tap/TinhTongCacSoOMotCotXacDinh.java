package Advanced_Programming_with_Java_2_1.ss3_Mang_va_phuong_thuc_trong_Java.Bai_tap;

import java.util.Scanner;

public class TinhTongCacSoOMotCotXacDinh {
    public static void main(String[] args) {
        System.out.println("Hiển Thị Các Số Ở Một Cột Xác Định");

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
        for (int columns = 0; columns < arr[0].length; columns++) {
            int total = 0;
            for (int row = 0; row < arr.length; row++)
                total += arr[row][columns];
                System.out.println("Sum for column " + columns + " is " + total);
        }

    }
}
