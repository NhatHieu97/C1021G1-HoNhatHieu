package Advanced_Programming_with_Java_2_1.ss26_De_thi_09.service;

import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.person.Customer;
import Advanced_Programming_with_Java_2_1.ss26_De_thi_09.controllers.DienThoaiTest;
import Advanced_Programming_with_Java_2_1.ss26_De_thi_09.models.DienThoai;
import Advanced_Programming_with_Java_2_1.ss26_De_thi_09.models.DienThoaiChinhHang;
import Advanced_Programming_with_Java_2_1.ss26_De_thi_09.models.DienThoaiXachTay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DienThoaiImpl implements IDienThoai {
    public static final String DIENTHOAICHINHHANG_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss26_De_thi_09\\data\\dienThoaiChinhHangProfile.csv";
    public static final String DIENTHOAIXACHTAY_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss26_De_thi_09\\data\\dienThoaiXachTayProfile.csv";
    Scanner scanner = new Scanner(System.in);
    public static List<DienThoai> dienThoaiList = new ArrayList<>();

    public DienThoaiImpl() {
        readFileDienThoai();
    }

    public static void readFileDienThoai() {
        dienThoaiList.clear();
        for (DienThoai dienThoais : readFromFileDienThoaiChinhHang()) {
            dienThoaiList.add(dienThoais);
        }
        for (DienThoai dienThoais : readFromFileDienThoaiXachTay()) {
            dienThoaiList.add(dienThoais);
        }
    }

    public String[] thuocTinhChung() {
        boolean check;
        double inputGiaBan = 0;
        int inputSoLuong = 0;

        System.out.println("Vui lòng nhập tên điện thoại: ");
        String inputTenDienThoai = scanner.nextLine();
        do {
            check = false;
            try {
                System.out.println("Vui lòng nhập giá điện thoại: ");
                inputGiaBan = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi format người dùng. Vui lòng nhập lại!");
                check = true;
                continue;
            }
            if (inputGiaBan < 0) {
                System.out.println("Lỗi giá điện thoại nhỏ hơn không. Vui lòng nhập lại!");
                check = true;
                continue;
            }
        } while (check);

        do {
            check = false;
            try {
                System.out.println("Vui lòng nhập số lượng điện thoại: ");
                inputSoLuong = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi format người dùng. Vui lòng nhập lại!");
                check = true;
                continue;
            }
            if (inputSoLuong < 0) {
                System.out.println("Lỗi số lượng điện thoại nhỏ hơn không. Vui lòng nhập lại!");
                check = true;
                continue;
            }
        } while (check);

        System.out.println("Vui lòng nhập tên nhà sản xuất: ");
        String inputNhaSanXuat = scanner.nextLine();
        String[] dienThoai = {inputTenDienThoai, String.valueOf(inputGiaBan), String.valueOf(inputSoLuong), inputNhaSanXuat};
        return dienThoai;
    }

    @Override
    public void themMoi(int a) {
        boolean check;
        int inputThoiGianBaoHanh = 0;
        String inputTrangThai = null;
        String inputPhamViBaoHanh = null;
        if (a == 1) {
            String[] dienThoai = thuocTinhChung();
            do {
                check = false;
                try {
                    System.out.println("Vui lòng nhập thời gian bảo hành: ");
                    inputThoiGianBaoHanh = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi format người dùng. Vui lòng nhập lại!");
                    check = true;
                    continue;
                }
                if (inputThoiGianBaoHanh > 730 || inputThoiGianBaoHanh < 0) {
                    System.out.println("Lỗi thời gian bảo hành vượt quá 2 năm. Vui lòng nhập lại!");
                    check = true;
                    continue;
                }

            } while (check);

            do {
                check = false;
                System.out.println("Vui lòng phạm vi bảo hành: Toan Quoc hay Quoc Te");
                inputPhamViBaoHanh = scanner.nextLine();
                if (!inputPhamViBaoHanh.toLowerCase().equals("toan quoc") && !inputPhamViBaoHanh.toLowerCase().equals("quoc te")) {
                    System.out.println("Lỗi phạm vi bảo hành. Vui lòng nhập lại!");
                    check = true;
                    continue;
                }
            } while (check);

            DienThoaiChinhHang dienThoaiChinhHang = new DienThoaiChinhHang(dienThoai[0], Double.parseDouble(dienThoai[1]),
                    Integer.parseInt(dienThoai[2]), dienThoai[3], inputThoiGianBaoHanh, inputPhamViBaoHanh);
            dienThoaiList.add(dienThoaiChinhHang);
            writeFile();
        }
        if (a == 2) {
            String[] dienThoai = thuocTinhChung();
            String inputQuocGiaXachTay = null;
            do {
                check = false;
                try {
                    System.out.println("Vui lòng nhập quốc gia xách tay: ");
                    inputQuocGiaXachTay = scanner.nextLine();
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi format người dùng. Vui lòng nhập lại!");
                    check = true;
                    continue;
                }
                if (inputQuocGiaXachTay.toLowerCase().equals("viet nam")) {
                    System.out.println("Lỗi quốc gia xách tay không phải là Việt Nam. Vui lòng nhập lại!");
                    check = true;
                    continue;
                }
            } while (check);

            do {
                check = false;
                System.out.println("Vui lòng nhập trạng thái: ");
                inputTrangThai = scanner.nextLine();
                if (!inputTrangThai.toLowerCase().equals("da sua chua") && !inputTrangThai.toLowerCase().equals("chua sua chua")) {
                    System.out.println("Lỗi nhập sai trạng thái. Vui long nhập lại!");
                    check = true;
                    continue;
                }
            } while (check);

            DienThoaiXachTay dienThoaiXachTay = new DienThoaiXachTay(dienThoai[0], Double.parseDouble(dienThoai[1]),
                    Integer.parseInt(dienThoai[2]), dienThoai[3], inputQuocGiaXachTay, inputTrangThai);
            dienThoaiList.add(dienThoaiXachTay);
            writeFile();
        }
    }

    @Override
    public void xoa() {
        boolean check;
        int inputId = 0;

        do {
            check = false;
            try {
                System.out.println("Vui lòng nhập id điện thoại: ");
                inputId = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi format người dùng. Vui lòng nhập lại!");
                check = true;
                continue;
            }
        } while (check);

        for (int i = 0; i < dienThoaiList.size(); i++) {
            if (inputId == dienThoaiList.get(i).getId()) {
                do {
                    check = false;
                    System.out.println("Yes or No");
                    String yes = scanner.nextLine();
                    String no = scanner.nextLine();
                    if (!yes.toLowerCase().equals("yes") && !no.toLowerCase().equals("no")) {
                        System.out.println("Lỗi nhập sai. Vui lòng nhập lại!");
                        check = true;
                        continue;
                    }
                    if (yes.toLowerCase().equals("yes")) {
                        System.out.println(dienThoaiList.get(i));
                        dienThoaiList.remove(i);
                        break;
                    } else if (no.toLowerCase().equals("no")) {
                        DienThoaiTest.displayMainMenu();
                    }
                } while (check);
            }
        }
    }

    @Override
    public void danhSachDienThoai() {
        for (DienThoai dienThoai : dienThoaiList) {
            System.out.println(dienThoai);
        }

    }

    @Override
    public void timKiem() {
        boolean check;
        int inputId = 0;
        int choice = 0;
        do {
            check = false;
            System.out.println("Bạn muốn chọn tìm kiếm theo cách nào");
            System.out.println(DienThoaiTest.ALIGNMENT + "1. Tìm kiếm điện thoại theo ID");
            System.out.println(DienThoaiTest.ALIGNMENT + "2. Tìm Kiếm điện thoại theo tên điện thoại");
            System.out.println(DienThoaiTest.ALIGNMENT + "3. Quay lại thanh menu");
            System.out.println(DienThoaiTest.ALIGNMENT + "(^_^)___________(^_^)");
            System.out.println(DienThoaiTest.ALIGNMENT + "Vui lòng nhập sự lựa chọn của bạn !!!");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi format người dùng. Vui lòng nhập lại!");
                check = true;
                continue;
            }
            switch (choice) {
                case 1:
                    do {
                        check = true;
                        try {
                            System.out.println("Vui lòng nhập vào ID điện thoại");
                            inputId = Integer.parseInt(scanner.nextLine());

                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi format ID. Vui lòng nhập lại!");
                            check = true;
                            continue;
                        }
                        for (int i = 0; i < dienThoaiList.size(); i++) {
                            if (inputId == dienThoaiList.get(i).getId()) {
                                System.out.println(dienThoaiList.get(i));
                                check = false;
                                break;
                            }
                        }

                    } while (check);
                    break;

                case 2:
                    do {
                        check = true;
                        System.out.println("Vui lòng nhập vào tên điện thoại");
                        String inputTenDienThoai = scanner.nextLine();
                        for (int i = 0; i < dienThoaiList.size(); i++) {
                            if (dienThoaiList.get(i).getTenDienThoai().toLowerCase().contains(inputTenDienThoai.toLowerCase())) {
                                System.out.println(dienThoaiList.get(i));
                                check = false;
                            }
                        }
                    } while (check);
                    break;

                case 3:
                    DienThoaiTest.displayMainMenu();
                    break;

                default:
                    System.out.println(DienThoaiTest.ALIGNMENT + "Vui lòng kiểm tra lại danh sách !!!");
                    check = true;
                    continue;
            }
        } while (check);

    }

    public static void writeFile() {
        File dienThoaiChinhHang = new File(DIENTHOAICHINHHANG_PROFILE);
        File dienThoaiXachTay = new File(DIENTHOAIXACHTAY_PROFILE);
        try {
            FileWriter fileWriterChinhHang = new FileWriter(dienThoaiChinhHang);
            FileWriter fileWriterXachTay = new FileWriter(dienThoaiXachTay);
            BufferedWriter bufferedWriterChinhHang = new BufferedWriter(fileWriterChinhHang);
            BufferedWriter bufferedWriterXachTay = new BufferedWriter(fileWriterXachTay);
            List<DienThoaiChinhHang> dienThoaiChinhHangs = new ArrayList<>();
            List<DienThoaiXachTay> dienThoaiXachTays = new ArrayList<>();

            for (DienThoai dienThoai : dienThoaiList) {
                if (dienThoai instanceof DienThoaiChinhHang) {
                    dienThoaiChinhHangs.add((DienThoaiChinhHang) dienThoai);
                } else {
                    dienThoaiXachTays.add((DienThoaiXachTay) dienThoai);
                }
            }
            for (DienThoaiChinhHang dienThoaiChinhHang1 : dienThoaiChinhHangs) {
                bufferedWriterChinhHang.write(dienThoaiChinhHang1.getId() + "," + dienThoaiChinhHang1.getTenDienThoai() + "," +
                        dienThoaiChinhHang1.getGiaBan() + "," + dienThoaiChinhHang1.getSoLuong() + "," + dienThoaiChinhHang1.getNhaSanXuat() + "," +
                        dienThoaiChinhHang1.getThoiGianBaoHanh() + "," + dienThoaiChinhHang1.getPhamViBaoHanh());
                bufferedWriterChinhHang.newLine();
            }
            bufferedWriterChinhHang.close();
            for (DienThoaiXachTay dienThoaiXachTay1 : dienThoaiXachTays) {
                bufferedWriterXachTay.write(dienThoaiXachTay1.getId() + "," + dienThoaiXachTay1.getTenDienThoai() + "," +
                        dienThoaiXachTay1.getGiaBan() + "," + dienThoaiXachTay1.getSoLuong() + "," + dienThoaiXachTay1.getNhaSanXuat() + "," +
                        dienThoaiXachTay1.getQuocGiaXachTay() + "," + dienThoaiXachTay1.getTrangThai());
                bufferedWriterXachTay.newLine();
            }
            bufferedWriterXachTay.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<DienThoai> readFromFileDienThoaiXachTay() {
        List<DienThoai> dienThoaiXachTays = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(DIENTHOAIXACHTAY_PROFILE);
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String line;
            String temp[];
            DienThoaiXachTay dienThoaiXachTay;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                dienThoaiXachTay = new DienThoaiXachTay(temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]),
                        temp[4], temp[5], temp[6]);
                dienThoaiXachTay.setId(Integer.parseInt(temp[0]));
                dienThoaiXachTays.add(dienThoaiXachTay);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dienThoaiXachTays;
    }

    public static List<DienThoai> readFromFileDienThoaiChinhHang() {
        List<DienThoai> dienThoaiChinhHangs = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(DIENTHOAICHINHHANG_PROFILE);
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String line;
            String temp[];
            DienThoaiChinhHang dienThoaiChinhHang;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                dienThoaiChinhHang = new DienThoaiChinhHang(temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]),
                        temp[4], Integer.parseInt(temp[5]), temp[6]);
                dienThoaiChinhHang.setId(Integer.parseInt(temp[0]));
                dienThoaiChinhHangs.add(dienThoaiChinhHang);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dienThoaiChinhHangs;
    }
}
