package Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.service;


import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.person.Customer;
import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.person.Employee;
import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.person.Person;

import java.io.*;
import java.util.*;

public class EmployeeManagementIplm implements IPersonService {
    public static final String EMPLOYEE_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss25_CaseStudy\\faramaResort\\data\\employeeProfileReadWrite.csv";
    public static List<Employee> employees = new ArrayList<>();
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
        List<Employee> employees1 = new ArrayList<>();
        employees1 = readFromFile();
        if (employees1.size() == 0) {
            Employee employee1 = new Employee("VNK-" + numRamdom(), "Luong Bao", "10/10/1995", "male", "206216875", "0935654789", "Ngoduybao@gmail.com", "doctor", "serve", 5000);
            Employee employee2 = new Employee("VNK-" + numRamdom(), "Luong Linh", "01/07/1992", "male", "206216875", "0935654789", "Đanguylinh@gmail.com", "master", "director", 10000);
            Employee employee3 = new Employee("VNK-" + numRamdom(), "Luong Hoang", "10/10/1996", "male", "20527875", "0777123654", "Nguyenanhhoang@gmail.com", "college", "manager", 7000);
            employees.add(employee1);
            employees.add(employee2);
            employees.add(employee3);
            writeFile();
        }
    }
    public EmployeeManagementIplm(){
        employees = readFromFile();
    }

    @Override
    public void addNew(){
        employees.add(creatEmployee());
        writeFile();
    }

    public Employee creatEmployee() {
        String regexEmail = "[2-zA-Z][a-zA-Z0-9]+@gmail.com";
        String inputEmail;
        String regexPhone = "0[397][0378][0-9]{7}";
        String inputNumberPhone;
        String regexDate = "[0-9]{1,2}/[0-9]{1,2}/(19|20)[0-9]{2}";
        String inputDate;
        String inputGender;
        String regexCardNumber = "2[0-9]{8}";
        String inputIndetityCardNumber;
        String inputQuatification;
        String inputPosition;
        boolean check;
        double inputSalary = 0;

            System.out.println("INPUT NAME: ");
            String inputName = scanner.nextLine();

        do {
            check = false;
            System.out.println("INPUT DATE (DD/MM/YY): ");
            inputDate = scanner.nextLine();

            if(!inputDate.matches(regexDate)) {
                check = true;
                System.out.println("ERROR FORMAT DATE: ");
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
                        if(Integer.parseInt(temp[0]) < 0 || Integer.parseInt(temp[0]) > 29) {
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
                            System.out.println("ERROR FORMAT DATE: ");
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
                System.out.println("INPUT QUATIFICATION: UNIVERSITY, COLLEGE, INTERMEDIATE, MASTER, DOCTOR, PROFESSOR ");
                inputQuatification = scanner.nextLine();
                if(inputQuatification.toLowerCase().equals("university") || inputQuatification.toLowerCase().equals("college") ||
                        inputQuatification.toLowerCase().equals("intermediate") || inputQuatification.toLowerCase().equals("master") ||
                        inputQuatification.toLowerCase().equals("doctor") || inputQuatification.toLowerCase().equals("professor")) {
                    break;
                }
            }while (check);

            do{
                check = true;
                System.out.println("INPUT POSITION: RECEPTIONIST, SERVE, MONITOR, MANAGER, DIRECTOR ");
                inputPosition = scanner.nextLine();
                List<String> employee = new ArrayList<>();
                employee.add("receptionist");
                employee.add("serve");
                employee.add("monitor");
                employee.add("manager");
                employee.add("director");
                for(String employees: employee){
                    if (inputPosition.toLowerCase().equals(employees)) {
                        check = false;
                        break;
                    }
                }
            }while (check);



            do {
                check = false;
                try {
                    System.out.println("INPUT SALARY: ");
                    inputSalary = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERROR FORMAT SALARY: ");
                    check = true;
                }
            }while (check);
            Employee employee = new Employee("VNK-" + numRamdom(), inputName, inputDate, inputGender, inputIndetityCardNumber,
                    inputNumberPhone, inputEmail, inputQuatification, inputPosition, inputSalary);
            return employee;


    }
    public static void writeFile(){
        File customerProfile = new File(EMPLOYEE_PROFILE);
        try {
            FileWriter fileWriter = new FileWriter(customerProfile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee: employees){
                bufferedWriter.write(employee.getId() + "," + employee.getName() + "," + employee.getDayOfBirth() + "," +
                        employee.getGender() + "," + employee.getIdentityCardNumber() + "," + employee.getNumberPhone() + "," +
                        employee.getEmail() + "," + employee.getQuatification() + "," + employee.getPosition() + "," + employee.getSalary());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Employee> readFromFile(){
        List<Employee> employees = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(EMPLOYEE_PROFILE);
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String line;
            String temp[];
            Employee employee;
            while ((line = bufferedReader.readLine())!= null){
                temp = line.split(",");
                employee = new Employee(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8],Double.parseDouble(temp[9]));
                employees.add(employee);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void display() {
        if (employees.size() < 1) {
            System.out.println("DATA NOT EXIST, PLEASE INPUT NEW CUSTOMER: ");
        }else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }


    @Override
    public void edit() {
        String inputID;
        Employee employee = null;
        System.out.println("INPUT ID: ");
        inputID = scanner.nextLine();
        boolean check = false;
        for (int i = 0 ; i < employees.size(); i++){
            if(inputID.toUpperCase().equals(employees.get(i).getId())){
                String id = employees.get(i).getId();
                employee = creatEmployee();
                employee.setId(id);
                employees.set(i, employee);
                check = true;
                writeFile();
                break;
            }
        }
        if (!check) {
            System.out.println("CAN NOT FILE THIS ID, PLEASE TRY AGAIN!");
        }
    }
}







