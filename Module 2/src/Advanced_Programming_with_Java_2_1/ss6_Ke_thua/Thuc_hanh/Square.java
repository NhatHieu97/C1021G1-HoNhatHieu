package Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Thuc_hanh;

import Advanced_Programming_with_Java_2_1.ss7_Abstract_Class_And_Interface.Bai_tap.Resizeable;

public class Square extends Rectangle implements Resizeable {
    public Square(){
    }

    public Square(double side){
        super(side,side);
    }

    public Square(String colors, boolean filled, double side) {
        super(colors, filled, side, side);
    }

    public double getSide(){
        return getWidth();
    }
    public void setSide(double side){
        setWidth(side);
        setLength(side);
    }
    public double getArea(){
        return this.getWidth() * this.getLength();
    }


    @Override
    public String toString() {
        return "A Square with side= "
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
    @Override
    public void resize(double percent) {
        setSide(getSide() + (percent/100));
    }


    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square("red", true, 5.5);
        System.out.println(square);
    }
}
