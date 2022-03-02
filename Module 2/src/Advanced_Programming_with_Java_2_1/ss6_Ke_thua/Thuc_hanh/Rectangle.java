package Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Thuc_hanh;

import Advanced_Programming_with_Java_2_1.ss7_Abstract_Class_And_Interface.Bai_tap.Resizeable;

import java.io.IOException;
import java.nio.CharBuffer;

public class Rectangle extends Shape implements Resizeable {
    private double width = 1;
    private double length = 1;

    public Rectangle(){
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String colors, boolean filled, double width, double length) {
        super(colors, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getPerimeter(){
        return (getLength() + getWidth()) * 2;
    }

    public double getArea(){
        return getLength() * getWidth();
    }

    @Override
    public String toString() {
        return "A Rectangle with = "
                + getWidth()
                + " and length = "
                + getLength()
                + ", which is a subclass of "
                + super.toString();
    }
    @Override
    public void resize(double percent) {
        setWidth(getWidth()+ (percent/100));
        setLength(getLength() + (percent/100));
    }


    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(6,7);
//        System.out.println(rectangle);

        rectangle = new Rectangle("pink", false, 6 , 7);

    }



}
