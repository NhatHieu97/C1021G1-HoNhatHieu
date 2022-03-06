package service;

public class UngDung {
    public double chuyenDoi(double usd) {
        if (String.valueOf(usd).equals(""))
            return 0;
        else
            return usd*23000;
    }
}
