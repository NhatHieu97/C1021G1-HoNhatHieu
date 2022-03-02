package Advanced_Programming_with_Java_2_1.ss3_Mang_va_phuong_thuc_trong_Java.Bai_tap;

import java.util.Scanner;

public class TimPhanTuLonNhatTrongMang2Chieu {
    public static void main(String[] args) {
        System.out.println("Hiển Thị Phần tử Lớn Nhất Trong Mảng 2 Chiều: ");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number row: ");
        int a = input.nextInt();
        System.out.print("Enter the number columns: ");
        int b = input.nextInt();
        int[][] arr = new int[a][b];

        System.out.println("Enter " + arr.length + " rows and " + arr[0].length + " columns: ");

        for (int row = 0; row < a; row++){
            for (int columns = 0; columns < b; columns++){
                System.out.print("Nhập arr" + "[" + row + "]" + "[" + columns + "]: ");
                arr[row][columns] = input.nextInt();
            }
        }
        for (int row = 0; row < a; row++){
            for (int columns = 0; columns < b; columns++){
                System.out.print(arr[row][columns] + "\t");
            }
            System.out.println();
        }
        int soLonNhat = arr[0][0];
        for (int row = 0; row < a; row++){
            for (int columns = 0; columns < b; columns++){
                if (soLonNhat < arr[row][columns]){
                    soLonNhat = arr[row][columns];
                }
            }
        }
        System.out.println("The max is number: " + soLonNhat);
    }
}
