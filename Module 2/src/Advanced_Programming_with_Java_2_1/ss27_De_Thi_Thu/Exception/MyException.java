package Advanced_Programming_with_Java_2_1.ss27_De_Thi_Thu.Exception;

public class MyException extends Exception {
    public MyException(){}

    @Override
    public String getMessage() {
        return "Đây là MyException của tôi";
    }
}

