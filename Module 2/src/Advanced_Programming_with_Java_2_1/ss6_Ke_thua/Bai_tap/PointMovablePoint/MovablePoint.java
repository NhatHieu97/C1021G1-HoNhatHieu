package Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Bai_tap;

public class MovablePoint extends Point {
    public float xSpeed = 0.0f;
    public float ySpeed = 0.0f;

    public MovablePoint(){}

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] arr = new float[4];
        arr[0] = super.x;
        arr[1] = super.y;
        arr[2] = this.xSpeed;
        arr[3] = this.ySpeed;
        return arr;
    }
    public MovablePoint move(){
        this.x += xSpeed;
        this.y += ySpeed;
        return this;
    }

    @Override
    public String toString() {
        return  super.toString()+
                ", Point3D{" +
                " xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    public static void main(String[] args) {
        MovablePoint point3D = new MovablePoint();
        System.out.println(point3D);

        point3D = new MovablePoint(0.0f,0.0f,1.0f,2.0f);
        System.out.println(point3D);
        for (int i = 0; i < point3D.getSpeed().length; i++){
            System.out.println(point3D.getSpeed()[i]);
        }

        point3D.setSpeed(2.0f,3.0f);
        System.out.println(point3D);
        System.out.println("1: " + point3D.move());
        point3D.setSpeed(4.0f,5.0f);
        System.out.println(point3D);
        System.out.println("2: " + point3D.move());
        point3D.setSpeed(6.0f,7.0f);
        System.out.println(point3D);
        System.out.println("3: " + point3D.move());




    }
}
