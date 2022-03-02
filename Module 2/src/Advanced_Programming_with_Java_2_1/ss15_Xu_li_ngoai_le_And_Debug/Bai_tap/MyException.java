package Advanced_Programming_with_Java_2_1.ss15_Xu_li_ngoai_le_And_Debug.Bai_tap;

public class MyException extends Exception {
    public MyException(){}

    @Override
    public String getMessage() {
        return "Đây là MyException của tôi";
    }
}
