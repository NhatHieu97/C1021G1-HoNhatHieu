package Advanced_Programming_with_Java_2_1.ss7_Abstract_Class_And_Interface.Bai_tap.Colorable;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[1];
        shapes[0] = new Square(5);

        for (Shape shape : shapes){

            if(shape instanceof Colorable){
                Square square = (Square) shape ;
                System.out.println(square.getArea());
                square.howToColor();
            }
        }
    }
}
