package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_3.Service;

import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_3.Officals;

public interface OfficalsService {
    Officals[] findAll();
    void add(Officals officals);
    void femaleCount();
    void listIt();

}
