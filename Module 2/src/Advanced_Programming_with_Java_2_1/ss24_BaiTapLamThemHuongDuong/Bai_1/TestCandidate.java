package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_1;

import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_1.Service.CadicateServiceImpl;
import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_1.Service.ICandicateService;

import java.util.Scanner;

public class TestCandidate {
    public static void main(String[] args) {

        Candidate[] candidates = null;
        ICandicateService iCandicateService = new CadicateServiceImpl();


        Scanner input = new Scanner(System.in);
        int select = 0;
        candidates = iCandicateService.findAll();

        do {
            System.out.println("--Cadicate Menu--");
            System.out.println("1. List all");
            System.out.println("2. Add new");
            System.out.println("9. Exit");

            select = Integer.parseInt(input.nextLine());
            switch (select) {
                case 1:

                    for (Candidate candidate : candidates) {
                        if(candidate == null){
                            break;
                        }
                        System.out.println(candidate);
                    }
                    break;
                case 2:

                    System.out.print("Input id: ");
                    int id = Integer.parseInt(input.nextLine());
                    System.out.print("Input name: ");
                    String name = input.nextLine();
                    System.out.print("Math score: ");
                    double toan = Double.parseDouble(input.nextLine());
                    System.out.print("literature score: ");
                    double van = Double.parseDouble(input.nextLine());
                    System.out.print("English score: ");
                    double anh = Double.parseDouble(input.nextLine());

                    Candidate candidateNew = new Candidate(id, name, toan, van, anh);
                    iCandicateService.addCadidate(candidateNew);
                    break;
                case 9:
                    for (Candidate candidate : candidates) {
                        if (candidate.diemThi()> 15){
                            System.out.println(candidate);
                        }
                    }
                        break;
                default:
                    System.out.println("input err!");
            }
        }
        while (select != 9);


    }
}
