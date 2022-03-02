package Advanced_Programming_with_Java_2_1.ss28_De_Thi_Module_2.service;
import Advanced_Programming_with_Java_2_1.ss28_De_Thi_Module_2.controllers.SanPhamTest;
import Advanced_Programming_with_Java_2_1.ss28_De_Thi_Module_2.models.SanPham;
import Advanced_Programming_with_Java_2_1.ss28_De_Thi_Module_2.models.SanPhamNhapKhau;
import Advanced_Programming_with_Java_2_1.ss28_De_Thi_Module_2.models.SanPhamXuatKhau;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SanPhamImpl implements ISanPham {
    public static final String SANPHAMNHAPKHAU_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss28_De_Thi_Module_2\\data\\sanPhamNhapKhauProfile.csv";
    public static final String SANPHAMXUATKHAU_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss28_De_Thi_Module_2\\data\\sanPhamXuatKhauProfile.csv";
    Scanner scanner = new Scanner(System.in);
    public static List<SanPham> sanPhamList = new ArrayList<>();

    public SanPhamImpl() {
        readFileSanPham();
    }

    public static void readFileSanPham() {
        sanPhamList.clear();
        for (SanPham sanPham : readFromFileSanPhamNhapKhau()) {
            sanPhamList.add(sanPham);
        }
        for (SanPham sanPham : readFromFileSanPhamXuatKhau()) {
            sanPhamList.add(sanPham);
        }
    }

    public String[] thuocTinhChung() {
        boolean check;
        double inputGiaBan = 0;
        int inputSoLuong = 0;
        String regexMaSanPham = "[S][P][0-9]{5}";
        String inputMaSanPham;
        do {
            check = false;
            System.out.println("Vui lòng nhập mã sản phẩm: ");
            inputMaSanPham = scanner.nextLine();
            if(!inputMaSanPham.matches(regexMaSanPham)){
                System.out.println("Lỗi nhập sai regex");
                check = false;
                continue;
            }

        }while (check);


        System.out.println("Vui lòng nhập tên sản phẩm: ");
        String inputTenSanPham = scanner.nextLine();
        do {
            check = false;
            try {
                System.out.println("Vui lòng nhập giá bán sản phẩm: ");
                inputGiaBan = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi format người dùng. Vui lòng nhập lại!");
                check = true;
                continue;
            }
            if (inputGiaBan < 0) {
                System.out.println("Lỗi giá sản phẩm nhỏ hơn không. Vui lòng nhập lại!");
                check = true;
                continue;
            }
        } while (check);

        do {
            check = false;
            try {
                System.out.println("Vui lòng nhập số lượng sản phẩm: ");
                inputSoLuong = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi format người dùng. Vui lòng nhập lại!");
                check = true;
                continue;
            }
            if (inputSoLuong < 0) {
                System.out.println("Lỗi số lượng sản phẩm nhỏ hơn không. Vui lòng nhập lại!");
                check = true;
                continue;
            }
        } while (check);

        System.out.println("Vui lòng nhập tên nhà sản xuất: ");
        String inputNhaSanXuat = scanner.nextLine();
        String[] sanPham = {inputMaSanPham, inputTenSanPham, String.valueOf(inputGiaBan), String.valueOf(inputSoLuong), inputNhaSanXuat};
        return sanPham;
    }

    @Override
    public void themMoi(int a) {
        boolean check;
        double inputGiaNhapKhau = 0;
        String inputTinhThanhNhap = null;
        double inputThueNhapKhau = 0;
        if (a == 1) {
            String[] sanphams = thuocTinhChung();
            do {
                check = false;
                try {
                    System.out.println("Vui lòng nhập giá nhập khẩu: ");
                    inputGiaNhapKhau = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi format người dùng. Vui lòng nhập lại!");
                    check = true;
                    continue;
                }
                if (inputGiaNhapKhau < 0) {
                    System.out.println("Lỗi giá nhập khẩu nhỏ hơn 0. Vui lòng nhập lại!");
                    check = true;
                    continue;
                }

            } while (check);


            System.out.println("Vui lòng nhâp tỉnh thành");
            inputTinhThanhNhap = scanner.nextLine();
            System.out.println("Vui lòng nhâp thuế nhập khẩu");
            inputThueNhapKhau = Double.parseDouble(scanner.nextLine());


            SanPhamNhapKhau sanPhamNhapKhau = new SanPhamNhapKhau(sanphams[0], sanphams[1], Double.parseDouble(sanphams[2]),
                    Integer.parseInt(sanphams[3]), sanphams[4], inputGiaNhapKhau, inputTinhThanhNhap, inputThueNhapKhau);
            sanPhamList.add(sanPhamNhapKhau);
            writeFile();
        }
        if (a == 2) {
            String[] sanphams = thuocTinhChung();
            double inputGiaXuatKhau = 0;
            String inputQuocGiaNhapSanPham = null;

            do {
                check = false;
                try {
                    System.out.println("Vui lòng nhập giá xuất khẩu: ");
                    inputGiaXuatKhau = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi format người dùng. Vui lòng nhập lại!");
                    check = true;
                    continue;
                }
                if (inputGiaXuatKhau < 0) {
                    System.out.println("Lỗi giá xuất khẩu nhỏ hơn 0. Vui lòng nhập lại!");
                    check = true;
                    continue;
                }

            } while (check);

            System.out.println("Vui lòng nhập quốc gia nhập sản phẩm: ");
            inputQuocGiaNhapSanPham = scanner.nextLine();


            SanPhamXuatKhau sanPhamXuatKhau = new SanPhamXuatKhau(sanphams[0], sanphams[1], Double.parseDouble(sanphams[2]),
                    Integer.parseInt(sanphams[3]), sanphams[4], inputGiaXuatKhau, inputQuocGiaNhapSanPham);
            sanPhamList.add(sanPhamXuatKhau);
            writeFile();
        }
    }

    @Override
    public void xoa() {
        boolean check;
        String inputMaSanPham = null;

        do {
            check = false;
            try {
                System.out.println("Vui lòng nhập mã sản phẩm: ");
                inputMaSanPham = scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Lỗi format người dùng. Vui lòng nhập lại!");
                check = true;
                continue;
            }
        } while (check);

        for (int i = 0; i < sanPhamList.size(); i++) {
            if (inputMaSanPham.toLowerCase().equals(sanPhamList.get(i).getMaSanPham())) {
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
                        System.out.println(sanPhamList.get(i));
                        sanPhamList.remove(i);
                        writeFile();
                        break;
                    } else if (no.toLowerCase().equals("no")) {
                        SanPhamTest.displayMainMenu();
                    }
                } while (check);
            }
        }
    }

    @Override
    public void danhSachSanPham() {
        for (SanPham sanPham : sanPhamList) {
            System.out.println(sanPham);
        }
    }

    @Override
    public void timKiem() {
        boolean check;
        String inputMaSanPham = null;
        int choice = 0;
        do {
            check = false;
            System.out.println("Bạn muốn chọn tìm kiếm theo cách nào");
            System.out.println(SanPhamTest.ALIGNMENT + "1. Tìm kiếm sản phẩm theo mã sản phẩm");
            System.out.println(SanPhamTest.ALIGNMENT + "2. Tìm Kiếm sản phẩm theo tên sản phẩm");
            System.out.println(SanPhamTest.ALIGNMENT + "3. Quay lại thanh menu");
            System.out.println(SanPhamTest.ALIGNMENT + "(^_^)___________(^_^)");
            System.out.println(SanPhamTest.ALIGNMENT + "Vui lòng nhập sự lựa chọn của bạn !!!");
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
                            System.out.println("Vui lòng nhập vào mã sản phẩm");
                            inputMaSanPham = scanner.nextLine();

                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi format ID. Vui lòng nhập lại!");
                            check = true;
                            continue;
                        }
                        for (int i = 0; i < sanPhamList.size(); i++) {
                            if (inputMaSanPham.toLowerCase().equals(sanPhamList.get(i).getMaSanPham())) {
                                System.out.println(sanPhamList.get(i));
                                check = false;
                                break;
                            }
                        }

                    } while (check);
                    break;
                case 2:
                    do {
                        check = true;
                        System.out.println("Vui lòng nhập vào tên sản phẩm");
                        String inputTenDienThoai = scanner.nextLine();
                        for (int i = 0; i < sanPhamList.size(); i++) {
                            if (sanPhamList.get(i).getTenSanPham().toLowerCase().contains(inputTenDienThoai.toLowerCase())) {
                                System.out.println(sanPhamList.get(i));
                                check = false;
                            }
                        }
                    } while (check);
                    break;
                case 3:
                    SanPhamTest.displayMainMenu();
                    break;

                default:
                    System.out.println(SanPhamTest.ALIGNMENT + "Vui lòng kiểm tra lại danh sách !!!");
                    check = true;
                    continue;
            }
        } while (check);
    }

    public static void writeFile() {
        File sanPhamNhapKhau = new File(SANPHAMNHAPKHAU_PROFILE);
        File sanPhamXuatKhau = new File(SANPHAMXUATKHAU_PROFILE);
        try {
            FileWriter fileWriterNhapKhau = new FileWriter(sanPhamNhapKhau);
            FileWriter fileWriterXuatKhau = new FileWriter(sanPhamXuatKhau);
            BufferedWriter bufferedWriterNhapKhau = new BufferedWriter(fileWriterNhapKhau);
            BufferedWriter bufferedWriterXuatKhau = new BufferedWriter(fileWriterXuatKhau);
            List<SanPhamNhapKhau> sanPhamNhapKhaus = new ArrayList<>();
            List<SanPhamXuatKhau> sanPhamXuatKhaus = new ArrayList<>();

            for (SanPham sanPham : sanPhamList) {
                if (sanPham instanceof SanPhamNhapKhau) {
                    sanPhamNhapKhaus.add((SanPhamNhapKhau) sanPham);
                } else {
                    sanPhamXuatKhaus.add((SanPhamXuatKhau) sanPham);
                }
            }
            for (SanPhamNhapKhau sanPhamNhapKhau1 : sanPhamNhapKhaus) {
                bufferedWriterNhapKhau.write(sanPhamNhapKhau1.getId() + "," + sanPhamNhapKhau1.getMaSanPham() + "," + sanPhamNhapKhau1.getTenSanPham() + "," +
                        sanPhamNhapKhau1.getGiaBan() + "," + sanPhamNhapKhau1.getSoLuong() + "," + sanPhamNhapKhau1.getNhaSanXuat() + "," +
                        sanPhamNhapKhau1.getGiaNhapKhau() + "," + sanPhamNhapKhau1.getTinhThanhNhap() + "," + sanPhamNhapKhau1.getThueNhapKhau());
                bufferedWriterNhapKhau.newLine();
            }
            bufferedWriterNhapKhau.close();
            for (SanPhamXuatKhau sanPhamXuatKhau1 : sanPhamXuatKhaus) {
                bufferedWriterXuatKhau.write(sanPhamXuatKhau1.getId() + "," + sanPhamXuatKhau1.getMaSanPham() + "," + sanPhamXuatKhau1.getTenSanPham() + "," +
                        sanPhamXuatKhau1.getGiaBan() + "," + sanPhamXuatKhau1.getSoLuong() + "," + sanPhamXuatKhau1.getNhaSanXuat() + "," +
                        sanPhamXuatKhau1.getGiaXuatKhau() + "," + sanPhamXuatKhau1.getQuocGiaNhapSanPham());
                bufferedWriterXuatKhau.newLine();
            }
            bufferedWriterXuatKhau.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<SanPham> readFromFileSanPhamNhapKhau() {
        List<SanPham> sanPhams = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(SANPHAMNHAPKHAU_PROFILE);
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String line;
            String temp[];
            SanPhamNhapKhau sanPhamNhapKhau;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                sanPhamNhapKhau = new SanPhamNhapKhau(temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]),
                        temp[5], Double.parseDouble(temp[6]), temp[7], Double.parseDouble(temp[8]));
                sanPhamNhapKhau.setId(Integer.parseInt(temp[0]));
                sanPhams.add(sanPhamNhapKhau);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }

    public static List<SanPham> readFromFileSanPhamXuatKhau() {
        List<SanPham> sanPhams = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(SANPHAMXUATKHAU_PROFILE);
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String line;
            String temp[];
            SanPhamXuatKhau sanPhamXuatKhau;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                sanPhamXuatKhau = new SanPhamXuatKhau(temp[1], temp[2], Double.parseDouble(temp[3]), Integer.parseInt(temp[4]),
                        temp[5], Double.parseDouble(temp[6]), temp[7]);
                sanPhamXuatKhau.setId(Integer.parseInt(temp[0]));
                sanPhams.add(sanPhamXuatKhau);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sanPhams;
    }
}
