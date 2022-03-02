package Advanced_Programming_with_Java_2_1.ss1_Introduction_to_Java.Thuc_hanh;



import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter width: ");
        width = scanner.nextFloat();
        System.out.println("Enter height: ");
        height = scanner.nextFloat();
        float area = width * height;

        System.out.println("Area is :"+ area);
    }
}
