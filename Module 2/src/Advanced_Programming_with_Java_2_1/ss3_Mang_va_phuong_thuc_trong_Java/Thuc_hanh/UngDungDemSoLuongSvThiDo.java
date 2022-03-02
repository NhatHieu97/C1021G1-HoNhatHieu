package Advanced_Programming_with_Java_2_1.ss3_Mang_va_phuong_thuc_trong_Java.Bai_tap;

import java.util.Scanner;

public class UngDungDemSoLuongSvThiDo {
    public static void main(String[] args) {
        System.out.println("Ứng dụng quản lý sv thi đỗ: ");

        int size;
        int[] arr;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Enter the size: ");
            size = input.nextInt();
            if (size > 30){
                System.out.println("Size should not exceed 30");
            }
        }while (size > 30);
        arr = new int[size];
        for (int i = 0; i < arr.length; i++){
            System.out.print("Enter a mark for student " + (i + 1) + ": ");
            arr[i] = input.nextInt();
        }

        int count = 0;
        System.out.println("List of mark: ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
            if (arr[i] > 5 && arr[i] <= 10){
                count++;
            }
        }
        System.out.println("\n The number of students passing the exam is " + count);
    }
}
