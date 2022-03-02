package Advanced_Programming_with_Java_2_1.ss7_Abstract_Class_And_Interface.Bai_tap.Colorable;

public class Square extends Shape implements Colorable {
    private double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    public Square() {
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    @Override
    public String toString() {
        return "Square{" +
                "edge=" + edge +
                '}';
    }

    @Override
    public double getArea() {
        return edge * edge;
    }


    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
