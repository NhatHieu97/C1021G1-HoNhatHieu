package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_1.Service;

import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_1.Candidate;

public interface ICandicateService {
    Candidate[] findAll();
    void addCadidate(Candidate candidate);
}
