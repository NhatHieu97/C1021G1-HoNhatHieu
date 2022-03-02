package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_1.Service;

import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_1.Candidate;

import java.util.Scanner;

public class CadicateServiceImpl implements ICandicateService {
    private static Candidate[] candidatelist = new Candidate[5];


//    static {
//        candidatelist[0] = new Candidate(1, "Đạt", 7.0, 8.0, 10.0);
//        candidatelist[1] = new Candidate(2, "Bảo", 5.3, 9.5, 3.0);
//        candidatelist[2] = new Candidate(3, "Sơn", 6.2, 7.0, 5.3);
//        candidatelist[3] = new Candidate(4, "Linh", 3.0, 5.1, 5.3);
//        candidatelist[4] = new Candidate(5, "Lộc", 8.0, 5.1, 8.0);
//
//    }
    @Override
    public Candidate[] findAll() {
        return candidatelist;
    }

    @Override
    public void addCadidate(Candidate candidate) {
        for (int i = 0; i < candidatelist.length; i++){
            if(candidatelist[i]==null){
                candidatelist[i] = candidate;
                break;
            }

        }

    }
}
