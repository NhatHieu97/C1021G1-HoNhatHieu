package Advanced_Programming_with_Java_2_1.ss27_De_Thi_Thu.service;

import Advanced_Programming_with_Java_2_1.ss15_Xu_li_ngoai_le_And_Debug.Bai_tap.MyException;
import Advanced_Programming_with_Java_2_1.ss26_De_thi_09.controllers.DienThoaiTest;
import Advanced_Programming_with_Java_2_1.ss27_De_Thi_Thu.controllers.PersonsTest;
import Advanced_Programming_with_Java_2_1.ss27_De_Thi_Thu.models.GiangVien;
import Advanced_Programming_with_Java_2_1.ss27_De_Thi_Thu.models.HocVien;
import Advanced_Programming_with_Java_2_1.ss27_De_Thi_Thu.models.Persons;

import java.io.*;
import java.util.*;

public class PersonsImpl implements IPersons {
    public static final String HOCVIEN_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss27_De_Thi_Thu\\data\\HOCVIEN_PROFILE.csv";
    public static final String GIANGVIEN_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss27_De_Thi_Thu\\data\\GIANGVIEN_PROFILE.csv";
    Scanner scanner = new Scanner(System.in);
    public static List<Persons> personsList = new ArrayList<>();

    public PersonsImpl() {
        readFilePersons();
    }

    public static void readFilePersons() {
        personsList.clear();
        for (Persons persons : readFromFileHocVien()) {
            personsList.add(persons);
        }
        for (Persons persons : readFromFileGiangVien()) {
            personsList.add(persons);
        }
    }
    public static int ramdom(){
        int numrd = 0;
        Random rd = new Random();
        numrd = rd.nextInt(9);
        return numrd;
    }
    public static String numRamdom(){
        String result = "";
        for (int i = 0; i < 4; i++){
            result += (ramdom() + "");
        }
        return result;
    }
    public String[] thuocTinhChung() {
        String regexNgaySinh = "[0-9]{1,2}/[0-9]{1,2}/(20|19)[0-9]{2}";
        boolean check;
        String inputNgaySinh;
        String inputGioiTinh;
        System.out.println("Vui lòng nhập tên: ");
        String inputTen = scanner.nextLine();
        do {
            check = false;
            System.out.println("INPUT DATE (DD/MM/YY): ");
            inputNgaySinh = scanner.nextLine();

            if(!inputNgaySinh.matches(regexNgaySinh)) {
                check = true;
                System.out.println("ERROR FORMAT DATE NUMBER: ");
                continue;
            }
            String[] temp = inputNgaySinh.split("/");
            if(Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 12){
                check = true;
                System.out.println("ERROR FORMAT DATE: ");
                continue;
            }
            if(Integer.parseInt(temp[1]) == 1 || Integer.parseInt(temp[1]) == 3 || Integer.parseInt(temp[1]) == 5 || Integer.parseInt(temp[1]) == 7 ||
                    Integer.parseInt(temp[1]) == 8 || Integer.parseInt(temp[1]) == 10 || Integer.parseInt(temp[1]) == 12 ){
                if(Integer.parseInt(temp[0]) < 0 || Integer.parseInt(temp[0]) > 31) {
                    check = true;
                    System.out.println("ERROR FORMAT DATE: ");
                    continue;
                }
            }else if(Integer.parseInt(temp[1]) == 2){
                if ((Integer.parseInt(temp[2]) % 4 == 0 && Integer.parseInt(temp[2]) % 100 != 0) || Integer.parseInt(temp[2]) % 400 == 0){
                    if(Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 29) {
                        check = true;
                        System.out.println("ERROR FORMAT DATE: ");
                        continue;
                    }
                }else {
                    if(Integer.parseInt(temp[0]) < 0 || Integer.parseInt(temp[0]) > 28) {
                        check = true;
                        System.out.println("ERROR FORMAT DATE: ");
                        continue;
                    }
                }

            }else if (Integer.parseInt(temp[1]) > 0 || Integer.parseInt(temp[1]) < 13){
                if(Integer.parseInt(temp[0]) < 0 || Integer.parseInt(temp[0]) > 30) {
                    check = true;
                    continue;
                }
            }else {
                check = true;
            }

        }while (check);

        do {
            check = true;
            System.out.println("Vui lòng nhập giới tính: ");
            inputGioiTinh = scanner.nextLine();
            if(inputGioiTinh.toLowerCase().equals("nam") || inputGioiTinh.toLowerCase().equals("nu")){
                break;
            }
        }while (check);



        String[] person = {inputTen, inputNgaySinh, inputGioiTinh};

    return person;
    }

    @Override
    public void themMoi(int a) {

        if (a == 1){
            String[] person = thuocTinhChung();
            System.out.println("Vui lòng nhập lớp: ");
            String inputLop = scanner.nextLine();
            System.out.println("Vui lòng nhập điểm sô: ");
            double inputDiemSo = Double.parseDouble(scanner.nextLine());
            HocVien hocVien = new HocVien("HV-" + numRamdom(),person[0],person[1],person[2],inputLop,inputDiemSo);
            personsList.add(hocVien);
            writeFile();
        }
        if (a == 2){
            String[] person = thuocTinhChung();
            System.out.println("Vui lòng nhập chuyên môn: ");
            String inputChuyenMon = scanner.nextLine();
            GiangVien giangVien = new GiangVien("GV-" + numRamdom(),person[0],person[1],person[2],inputChuyenMon);
            personsList.add(giangVien);
            writeFile();
        }

    }

    @Override
    public void xoa() {
        boolean check;
        String inputId = null;

        do {
            check = false;
            try {
                System.out.println("Vui lòng nhập id: ");
                inputId = scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Lỗi format người dùng. Vui lòng nhập lại!");
                check = true;
                continue;
            }
        } while (check);

        for (int i = 0; i < personsList.size(); i++) {
            if (inputId.equals(personsList.get(i).getId())) {
                do {
                    check = false;
                    System.out.println("Yes or No");
                    String yes = scanner.nextLine();
                    String no = scanner.nextLine();
                    if (!yes.toLowerCase().equals("yes") && !no.toLowerCase().equals("no")) {
                        System.out.println("Lỗi nhập sai. Vui lòng nhập lại!");
                        try {
                            throw new MyException();
                        } catch (MyException e) {
                            System.out.println(e.getMessage());
                        }
                        check = true;
                        continue;
                    }
                    if (yes.toLowerCase().equals("yes")) {
                        System.out.println(personsList.get(i));
                        personsList.remove(i);
                        writeFile();
                        break;
                    } else if (no.toLowerCase().equals("no")) {

                        PersonsTest.displayMainMenu();
                    }
                } while (check);
            }
        }
    }

    @Override
    public void danhSachPersons() {
        for (Persons persons: personsList){
            System.out.println(persons);
        }
    }

    @Override
    public void timKiem() {
        boolean check;
        String inputId = null;
        int choice = 0;
        do {
            check = false;
            System.out.println("Bạn muốn chọn tìm kiếm theo cách nào");
            System.out.println(DienThoaiTest.ALIGNMENT + "1. Tìm kiếm danh sách theo ID");
            System.out.println(DienThoaiTest.ALIGNMENT + "2. Tìm Kiếm danh sách theo tên Học Sinh hoặc Giảng Viên");
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
                            System.out.println("Vui lòng nhập vào ID ");
                            inputId = scanner.nextLine();

                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi format ID. Vui lòng nhập lại!");
                            check = true;
                            continue;
                        }
                        for (int i = 0; i < personsList.size(); i++) {
                            if (inputId.equals(personsList.get(i).getId())) {
                                System.out.println(personsList.get(i));
                                check = false;
                                break;
                            }
                        }

                    } while (check);
                    break;

                case 2:
                    do {
                        check = true;
                        System.out.println("Vui lòng nhập vào tên Học Sinh hoặc Giảng Viên");
                        String inputTen = scanner.nextLine();
                        for (int i = 0; i < personsList.size(); i++) {
                            if (personsList.get(i).getTen().toLowerCase().contains(inputTen.toLowerCase())) {
                                System.out.println(personsList.get(i));
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
        File hocVien = new File(HOCVIEN_PROFILE);
        File giangVien = new File(GIANGVIEN_PROFILE);
        try {
            FileWriter fileWriterHocVien = new FileWriter(hocVien);
            FileWriter fileWriterGiangVien = new FileWriter(giangVien);
            BufferedWriter bufferedWriterHocVien = new BufferedWriter(fileWriterHocVien);
            BufferedWriter bufferedWriterGiangVien = new BufferedWriter(fileWriterGiangVien);
            List<HocVien> hocViens = new ArrayList<>();
            List<GiangVien> giangViens = new ArrayList<>();

            for (Persons persons : personsList) {
                if (persons instanceof HocVien) {
                    hocViens.add((HocVien) persons);
                } else {
                    giangViens.add((GiangVien) persons);
                }
            }
            for (HocVien hocVien1 : hocViens) {
                bufferedWriterHocVien.write(hocVien1.getId() + "," + hocVien1.getTen() + "," +
                        hocVien1.getNgaySinh() + "," + hocVien1.getGioiTinh() + "," + hocVien1.getLop() + "," +
                        hocVien1.getDiemSo());

                bufferedWriterHocVien.newLine();
            }
            bufferedWriterHocVien.close();
            for (GiangVien giangVien1 : giangViens) {
                bufferedWriterGiangVien.write(giangVien1.getId() + "," + giangVien1.getTen() + "," +
                        giangVien1.getNgaySinh() + "," + giangVien1.getGioiTinh() + "," + giangVien1.getChuyenMon());
                bufferedWriterGiangVien.newLine();
            }
            bufferedWriterGiangVien.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Persons> readFromFileHocVien() {
        List<Persons> persons = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(HOCVIEN_PROFILE);
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String line;
            String temp[];
            HocVien hocVien;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                hocVien = new HocVien(temp[0],temp[1], temp[2], temp[3],
                        temp[4], Double.parseDouble(temp[5]));
                persons.add(hocVien);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public static List<Persons> readFromFileGiangVien() {
        List<Persons> persons = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(GIANGVIEN_PROFILE);
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String line;
            String temp[];
            GiangVien giangVien;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                giangVien = new GiangVien(temp[0], temp[1], temp[2],temp[3],
                        temp[4]);
                persons.add(giangVien);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
