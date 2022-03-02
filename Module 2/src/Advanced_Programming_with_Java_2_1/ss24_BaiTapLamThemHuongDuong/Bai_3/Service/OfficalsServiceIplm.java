package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_3.Service;

import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_3.Officals;

public class OfficalsServiceIplm implements OfficalsService {
    private static Officals[] officals = new Officals[5];

    static {
        officals[0] = new Officals(1, "Đạt", "Male", "Quảng Nam", "28/11/1995", "Công nghệ thông tin", "Level 1", 2, 1000);
        officals[1] = new Officals(2, "Bảo", "Male", "Hà Nội", "10/12/1992", "Kỹ thuật điện điện tử", "Level 2", 6, 3500);
        officals[2] = new Officals(3, "Sơn", "female", "Thanh Hóa", "1/1/1997", "Xây dựng", "Level 3", 2, 2000);
        officals[3] = new Officals(4, "Linh", "Male", "Quảng Trị", "7/9/2001", "Kinh tế", "Level 4", 1.5, 1500);
        officals[4] = new Officals(5, "Lộc", "female", "Đà Nẵng", "13/11/2003", "Ngân hàng", "Level 5", 8, 4500);

    }







    @Override
    public Officals[] findAll() {
        return officals;
    }

    @Override
    public void add(Officals officals) {
        for (int i = 0; i < OfficalsServiceIplm.officals.length; i++){
            if (OfficalsServiceIplm.officals[i] == null){
                OfficalsServiceIplm.officals[i] = officals;
                break;
            }
        }
    }

    @Override
    public void femaleCount() {
        int count = 0;
        for (int i = 0; i < officals.length; i++ ){
            if(officals[i].getSex().equals("female")){
                count += 1;
                System.out.println(officals[i]);

            }
        }
        System.out.println("Officials has " + count + " female");

    }

    @Override
    public void listIt() {
        for (int i = 0; i < officals.length; i++ ){
            if(officals[i].getSpecicialize().equals("Công nghệ thông tin")){
                System.out.println(officals[i]);
            }
        }

    }




}
