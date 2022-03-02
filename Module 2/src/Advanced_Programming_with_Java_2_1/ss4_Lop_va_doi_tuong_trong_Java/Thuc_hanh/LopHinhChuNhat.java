package Advanced_Programming_with_Java_2_1.ss4_Lop_va_doi_tuong_trong_Java.Thuc_hanh;

import java.util.Scanner;

public class LopHinhChuNhat {
        double width, height;

        public LopHinhChuNhat() {
        }

        public LopHinhChuNhat (double width, double height){
            this.width = width;
            this.height = height;
        }

        public double getArea() {
            return this.width * this.height;
        }

        public double getPerimeter() {
            return (this.width + this.height) * 2;
        }

        public String display() {
            return "Rectangle{" + "width=" + width + ", height=" + height + "}";
        }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the width: ");
        double width = input.nextDouble();
        System.out.println("Enter the height: ");
        double height = input.nextDouble();

        LopHinhChuNhat rectangle = new LopHinhChuNhat(width,height);
        System.out.println("Your Rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());

    }
}
