package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong;

public class Demo {
    public static String quoGia = "viet nam";

    public Demo() {
    }

    public static String getQuoGia() {
        return quoGia;
    }

    public static void setQuoGia(String quoGia) {
        Demo.quoGia = quoGia;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Demo demo1 = new Demo();

        demo1.setQuoGia("nhatban");

        System.out.println(demo.getQuoGia());

        System.out.println(demo1.getQuoGia());

}
}

