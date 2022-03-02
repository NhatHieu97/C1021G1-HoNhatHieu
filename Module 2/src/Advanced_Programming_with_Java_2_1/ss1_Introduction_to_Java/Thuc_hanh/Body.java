package Advanced_Programming_with_Java_2_1.ss1_Introduction_to_Java.Thuc_hanh;

import java.util.Scanner;

public class Body {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight, height, bmi;
        System.out.print("You weight (in kilogam):");
        weight = sc.nextDouble();
        System.out.print("You height (in meter):");
        height = sc.nextDouble();

        bmi = weight / Math.pow(height,2);
        System.out.printf("%-20s%s", "bmi","Interpretation\n");

        if (bmi < 18.0)
            System.out.printf("%-20f%s",bmi,"Underweight");
        else if (bmi < 25.0)
        System.out.printf("%-20f%s",bmi,"Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20f%s",bmi,"Overweight");
        else
            System.out.printf("%-20f%s",bmi,"Obese");

    }
}
