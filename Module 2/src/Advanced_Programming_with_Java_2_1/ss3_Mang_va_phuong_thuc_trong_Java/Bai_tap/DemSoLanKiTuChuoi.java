package Advanced_Programming_with_Java_2_1.ss3_Mang_va_phuong_thuc_trong_Java.Bai_tap;

import java.util.Scanner;

public class DemSoLanKiTuChuoi {
    public static void main(String[] args) {
        System.out.println("Đếm số lần xuất hiện kí tự chuỗi");

        Scanner input = new Scanner(System.in);
        String str = "Cac bai hat, bai thơ Tet Trung thu luôn la chủ đề đuoc nhieu tim kiem moi khi Tet Trung thu đen";
        char[] charArray = str.toCharArray();
        System.out.println(charArray);
        System.out.print("Nhập kí tự: ");
        char kiTu = input.next().charAt(0);

        int count = 0;

        for (int i = 0; i < charArray.length; i++){
            if (kiTu == charArray[i]){
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của kí tự nhập là: " + count);



    }
}
