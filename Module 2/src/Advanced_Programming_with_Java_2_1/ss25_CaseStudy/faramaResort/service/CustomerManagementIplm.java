package Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.service;

import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.person.Customer;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CustomerManagementIplm implements IPersonService {
    public static final String CUSTOMER_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss25_CaseStudy\\faramaResort\\data\\customerProfileReadWrite.csv";
    public static List<Customer> customers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
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
    static {
        List<Customer> customers1 = new ArrayList<>();
        customers1 = readFromFile();
        if (customers1.size() == 0){
            Customer customer1 = new Customer("VN-" + numRamdom(),"Luong Bao", "10/10/1995", "male", "206216875","0935654789","Ngoduybao@gmail.com", "diamond", "danang");
            Customer customer2 = new Customer("VN-" + numRamdom(),"Luong Linh", "01/07/1992", "male", "206216875","0935654789","Đanguylinh@gmail.com", "platinium", "quangnam");
            Customer customer3 = new Customer("VN-" + numRamdom(),"Luong Hoang", "10/10/1996", "male", "20527875","0777123654","Nguyenanhhoang@gmail.com", "Gold", "hanoi");
            customers.add(customer1);
            customers.add(customer2);
            customers.add(customer3);
            writeFile();
        }
    }
    public CustomerManagementIplm(){
        customers = readFromFile();
    }



    @Override
    public void addNew() {
        customers.add(creatCustomer());
        writeFile();

    }
    public Customer creatCustomer() {
        String regexEmail = "[2-zA-Z][a-zA-Z0-9]+@gmail.com";
        String inputEmail;
        String regexPhone = "0[397][0378][0-9]{7}";
        String inputNumberPhone;
        String regexDate = "[0-9]{1,2}/[0-9]{1,2}/(20|19)[0-9]{2}";
        String inputDate;
        String inputGender;
        String regexCardNumber = "2[0-9]{8}";
        String inputIndetityCardNumber;
        String inputCustomerType;
        String inputAddress;
        boolean check;

        System.out.println("INPUT NAME: ");
        String inputName = scanner.nextLine();

        do {
            check = false;
            System.out.println("INPUT DATE (DD/MM/YY): ");
            inputDate = scanner.nextLine();

            if(!inputDate.matches(regexDate)) {
                check = true;
                System.out.println("ERROR FORMAT DATE NUMBER: ");
                continue;
            }
            String[] temp = inputDate.split("/");
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
            System.out.println("INPUT GENDER: ");
            inputGender = scanner.nextLine();
            if(inputGender.toLowerCase().equals("male") || inputGender.toLowerCase().equals("female")){
                break;
            }
        }while (check);

        do {
            check = false;
            System.out.println("INPUT INDETITY CARD NUMBER: ");
            inputIndetityCardNumber = scanner.nextLine();
            if(!inputIndetityCardNumber.matches(regexCardNumber)){
                check = true;
                System.out.println("ERROR FORMAT CARD NUMBER: ");
                continue;
            }

        }while (check);


        do {check = false;
            System.out.println("INPUT NUMBER PHONE: ");
            inputNumberPhone = scanner.nextLine();
            if(!inputNumberPhone.matches(regexPhone)) {
                check = true;
                System.out.println("ERROR FORMAT PHONE NUMBER: ");
                continue;
            }
        }while (check);

        do {
            check = false;
            System.out.println("INPUT EMAIL: ");
            inputEmail = scanner.nextLine();
            if(!inputEmail.matches(regexEmail)){
                check = true;
                System.out.println("ERROR FORMAT EMAIL: ");
                continue;
            }
        }while (check);

        do {
            check = true;
            System.out.println("INPUT CUMTOMER TYPE: DIAMOND, PLATINIUM, GOLD, SILVER  ");
            inputCustomerType = scanner.nextLine();
            if(inputCustomerType.toLowerCase().equals("diamond") || inputCustomerType.toLowerCase().equals("platinium") ||
                    inputCustomerType.toLowerCase().equals("gold") || inputCustomerType.toLowerCase().equals("silver")) {
                break;
            }
        }while (check);

            System.out.println("INPUT ADDRESS: ");
            inputAddress = scanner.nextLine();

        Customer customer = new Customer("VN-" + numRamdom(), inputName, inputDate, inputGender, inputIndetityCardNumber,
                inputNumberPhone, inputEmail, inputCustomerType, inputAddress);
        return customer;

    }
    public static void writeFile(){
        File customerProfile = new File(CUSTOMER_PROFILE);
        try {
            FileWriter fileWriter = new FileWriter(customerProfile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer: customers){
                bufferedWriter.write(customer.getId() + "," + customer.getName() + "," + customer.getDayOfBirth() + "," +
                        customer.getGender() + "," + customer.getIdentityCardNumber() + "," + customer.getNumberPhone() + "," +
                        customer.getEmail() + "," + customer.getCustomerType() + "," + customer.getAddress());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Customer> readFromFile(){
        List<Customer> customerss = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(CUSTOMER_PROFILE);
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String line;
            String temp[];
            Customer customer;
            while ((line = bufferedReader.readLine())!= null){
                temp = line.split(",");
                customer = new Customer(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
                customerss.add(customer);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerss;
    }

    @Override
    public void edit() {
        String inputID;
        Customer customer = null;
        System.out.println("INPUT ID: ");
        inputID = scanner.nextLine();
        boolean check = false;
        for (int i = 0 ; i < customers.size(); i++){
            if(inputID.toUpperCase().equals(customers.get(i).getId())){
                String id = customers.get(i).getId();
                customer = creatCustomer();
                customer.setId(id);
                customers.set(i, customer);
                check = true;
                writeFile();
                break;
            }
        }
        if (!check) {
            System.out.println("CAN NOT FILE THIS ID, PLEASE TRY AGAIN!");
        }
    }

    @Override
    public void display() {
        if (customers.size() < 1){
            System.out.println("DATA NOT EXIST, PLEASE INPUT NEW CUSTOMER: ");
        }else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }

    }

}
