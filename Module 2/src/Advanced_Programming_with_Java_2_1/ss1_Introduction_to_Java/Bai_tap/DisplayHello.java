package Advanced_Programming_with_Java_2_1.ss1_Introduction_to_Java.Bai_tap;

import java.util.Scanner;

public class DisplayHello {
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        String name;
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Hello: " + name);
    }
}
