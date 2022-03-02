package Advanced_Programming_with_Java_2_1.ss1_Introduction_to_Java.Bai_tap;

import java.util.Scanner;

public class VNDUSD {
    public static void main(String[] args) {
        System.out.println("Enter the money:");
        Scanner sc = new Scanner(System.in);
        int usd = sc.nextInt();
        int vnd = 23000 * usd;
        System.out.println("VND :" + vnd + " đồng");
    }
}
