package Advanced_Programming_with_Java_2_1.ss3_Mang_va_phuong_thuc_trong_Java.Bai_tap;

public class GopPhanTuCuaMang {
    public static void main(String[] args) {
        System.out.println("Gộp Phần Tử Của Mảng:");
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {5,6,7,8};
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++){
            result[i] = arr1[i];
        }
        for (int j = 0; j < arr1.length; j++){
            result[arr1.length + j] = arr2[j];
        }
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i]+ "\t");
        }
    }
}
