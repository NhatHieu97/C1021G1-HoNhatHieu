package Advanced_Programming_with_Java_2_1.ss4_Lop_va_doi_tuong_trong_Java.Bai_tap;

public class Fan {
    private static final int slow = 1;
    private static final int medium = 2;
    private static final int fast = 3;
    private int speed = slow;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    private Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed ;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (isOn()) {
            return "Fan{" +
                    "speed= " + speed +
                    ", on= " + on +
                    ", radius= " + radius +
                    ", color= '" + color + '\'' +
                    '}';
        } else {
            return  "fan is off";

        }
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan(medium, true, 20, "blue");
        Fan fan2 = new Fan(slow, false, 10, "blue");
        System.out.println(fan1);
        System.out.println(fan2);
    }

}

