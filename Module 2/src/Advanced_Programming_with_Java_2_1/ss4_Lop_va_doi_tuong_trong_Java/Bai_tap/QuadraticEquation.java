package Advanced_Programming_with_Java_2_1.ss4_Lop_va_doi_tuong_trong_Java.Bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    double a,b,c;

    public QuadraticEquation (double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

//    public double getA() {
//        return a;
//    }
//
//    public double getB() {
//        return b;
//    }
//
//    public double getC() {
//        return c;
//    }

    public double getDiscrinant() {
        return (b*b - 4*a*c);
    }
    public double getRoot1() {
        return (-b + Math.sqrt(getDiscrinant())) /2*a;
    }
    public double getRoot2() {
        return (-b - Math.sqrt(getDiscrinant()))/2*a;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number a:");
        double a = input.nextDouble();
        System.out.println("Enter the number b:");
        double b = input.nextDouble();
        System.out.println("Enter the number c:");
        double c = input.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);

        if (quadraticEquation.getDiscrinant() > 0){
            System.out.println("Phương trình có 2 nghiệm: " + "X1 = "+ quadraticEquation.getRoot1() + "X2= "+ quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscrinant() < 0) {
            System.out.println("The equation has no roots");
        } else {
            System.out.println("Phương trình có 2 nghiệm: " + "X1 = X2 = "+ quadraticEquation.getRoot1());
        }


    }

}
