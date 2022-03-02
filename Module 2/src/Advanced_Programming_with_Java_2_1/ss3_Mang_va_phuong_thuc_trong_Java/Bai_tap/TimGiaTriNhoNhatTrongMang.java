package Advanced_Programming_with_Java_2_1.ss3_Mang_va_phuong_thuc_trong_Java.Bai_tap;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        System.out.println("Hiển thị phần tử nhỏ nhất trong mảng: ");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number element: ");
        int a = input.nextInt();
        int[] arr = new int[a];

        for (int i = 0; i < arr.length; i++){
            System.out.print("Enter element: " + (i + 1) + " : ");
            arr[i] = input.nextInt();
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();

        int min = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (min > arr[i]){
                min = arr[i] ;
            }
        }
        System.out.println("The min element: " + min);
    }
}
