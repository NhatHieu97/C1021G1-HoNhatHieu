package Advanced_Programming_with_Java_2_1.ss3_Mang_va_phuong_thuc_trong_Java.Bai_tap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập sô phần tử: ");
        int a = input.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++){
            System.out.print("Nhập phần tử thứ " + (i + 1) + " : ");
            arr[i] = input.nextInt();
        }
        System.out.print("Nhập phần tử cần thêm trong mảng: ");
        int b = input.nextInt();
        System.out.print("Nhập vị trí cần thêm vào mảng: ");
        int index = input.nextInt();
        System.out.println("Thêm " + b + " vào vị trí thứ " + index);
        int[] arr1 = new int[a + 1];
        index -= 1;
        for (int j = 0; j < a + 1; j++){
            if (j == index){
                arr1[j] = b;
                System.out.print(arr1[j] + "\t");
            }else if (j > index){
                arr1[j] = arr[j - 1];
                System.out.print(arr1[j] + "\t");
            }else {
                System.out.print(arr[j] + "\t");
            }
        }



    }
}
