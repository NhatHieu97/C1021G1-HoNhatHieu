package Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Bai_tap;

public class Point2D3D {
    public float x = 0.0f;
    public float y = 0.0f;

    public Point2D3D(){}

    public Point2D3D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] arr = new float[2];
        arr[0] = this.x;
        arr[1] = this.y;
        return arr;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point2D3D point2D3D = new Point2D3D();
        System.out.println(point2D3D);

        point2D3D = new Point2D3D(0.5f,0.6f);
        System.out.println(point2D3D);

    }

}
