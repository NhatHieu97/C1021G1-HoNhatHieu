package Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Thuc_hanh;

import Advanced_Programming_with_Java_2_1.ss7_Abstract_Class_And_Interface.Bai_tap.Resizeable;

public class Shape{
    public String colors = "yellow";
    public boolean filled = true;

    public Shape(){
    }

    public Shape(String colors, boolean filled) {
        this.colors = colors;
        this.filled = filled;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A shape with color of " +
                getColors() +
                " and " + (isFilled() ? "filled" : "not filled");
    }




}
