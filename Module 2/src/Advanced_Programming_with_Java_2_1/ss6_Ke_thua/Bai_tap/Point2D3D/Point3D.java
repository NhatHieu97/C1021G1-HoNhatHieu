package Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Bai_tap;

public class Point3D extends Point2D3D {
    public float z = 0.0f;

    public Point3D (){
    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXY() {
        float[] arr = new float[3];
        arr[0] = super.x;
        arr[1] = this.y;
        arr[2] = this.z;
        return arr;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", " + super.toString() +
                '}';
    }

    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D);

        point3D = new Point3D(0.5f, 0.2f, 0.8f);
        for (int i = 0; i < point3D.getXY().length; i++){
            System.out.println(point3D.getXY()[i]);
        }


    }

}
