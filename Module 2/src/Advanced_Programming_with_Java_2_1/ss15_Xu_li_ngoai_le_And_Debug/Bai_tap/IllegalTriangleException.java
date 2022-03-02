package Advanced_Programming_with_Java_2_1.ss15_Xu_li_ngoai_le_And_Debug.Bai_tap;

public class IllegalTriangleException extends Exception {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public IllegalTriangleException(int a) {
        this.a = a;
    }

    @Override
    public String getMessage() {
        return "Không được là số âm";


    }

    public String getMessage1() {
        return "tổng 2 số lớn hơn 1 số";
    }
}
