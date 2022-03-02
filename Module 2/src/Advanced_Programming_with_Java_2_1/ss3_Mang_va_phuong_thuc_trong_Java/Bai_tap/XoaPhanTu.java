package Advanced_Programming_with_Java_2_1.ss3_Mang_va_phuong_thuc_trong_Java.Bai_tap;

import java.util.Scanner;

public class XoaPhanTu {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Nhập sô phần tử: ");
      int a = input.nextInt();
      int[] arr = new int[a];
      for (int i = 0; i < a; i++){
          System.out.print("Nhập phần tử thứ " + (i + 1) + " : ");
          arr[i] = input.nextInt();
      }
        System.out.println("Nhập phần tử cần xóa trong mảng");
        int x = input.nextInt();
      for (int j = 0; j < a; j++){
          if (arr[j] == x){
              continue;
          }
          System.out.print(arr[j] + "\t");
      }
      for (int k = 0; k < a; k++){
          if (arr[k] == x){
              System.out.println("Phần tử đã xóa ở vị trí "+ ++k);
          }
      }

    }
}
