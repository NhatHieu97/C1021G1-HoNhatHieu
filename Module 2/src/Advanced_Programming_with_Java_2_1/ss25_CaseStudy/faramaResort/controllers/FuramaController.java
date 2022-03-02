package Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.controllers;

import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.person.Customer;
import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuramaController {
    public static final String ALIGNMENT = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    public static final String ALIGNMENT1 = "\t\t\t\t\t\t\t\t\t\t\t\t\t";
    static Scanner scanner= new Scanner(System.in);
    static int choice;
    static boolean checkChoice;
    public static void main(String[] args) {
        displayMainMenu();
    }

    static void displayMainMenu(){
        do{

            checkChoice = false;
            System.out.println(ALIGNMENT1 + "(^_^) Furama resort management menu (^_^)");
            System.out.println(ALIGNMENT + "1. Employee management");
            System.out.println(ALIGNMENT + "2. Customer management");
            System.out.println(ALIGNMENT + "3. Facility management");
            System.out.println(ALIGNMENT + "4. Booking management");
            System.out.println(ALIGNMENT + "5. Promotion management");
            System.out.println(ALIGNMENT + "6 Exit");
            System.out.println();
            System.out.println(ALIGNMENT + "(^_^)___________(^_^)");
            System.out.println(ALIGNMENT + "Enter your selection");

            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println(ALIGNMENT +"look at the list carefully");
                checkChoice = true;
                continue;
            }

            switch (choice){
                case 1:
                    employeeManagement();
                    break;
                case 2:
                    customerManagement();
                    break;
                case 3:
                    facilityManagement();
                    break;
                case 4:
                    bookingManagement();
                    break;
                case 5:
                    promotionManagement();
                    break;
                case 6:
                    System.exit(0);

                default:
                    System.out.println(ALIGNMENT +"look at the list carefully");
                    checkChoice = true;
                    continue;
            }
        }while(checkChoice);
    }

    static void employeeManagement(){
        IPersonService iPersonService = new EmployeeManagementIplm();
        EmployeeManagementIplm employeeManagementIplm =new EmployeeManagementIplm();
        do {
            checkChoice = false;
            System.out.println(ALIGNMENT +"1. Display list employees");
            System.out.println(ALIGNMENT +"2. Add new employees");

            System.out.println(ALIGNMENT +"3. Edit employees");
            System.out.println(ALIGNMENT +"4. Return main menu");
            System.out.println();
            System.out.println(ALIGNMENT +"(^_^)___________(^_^)");
            System.out.println(ALIGNMENT +"Enter your selection");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(ALIGNMENT +"look at the list carefully");
                checkChoice = true;
                continue;
            }
            switch (choice){
                case 1:
                    iPersonService.display();
                    checkChoice = true;
                    continue;
                case 2:
                    iPersonService.addNew();
                    checkChoice = true;
                    continue;
                case 3:
                    employeeManagementIplm.edit();
                    checkChoice = true;
                    continue;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println(ALIGNMENT +"look at the list carefully");
                    checkChoice = true;
                    continue;
            }
        } while (checkChoice);

    }

    static void customerManagement() {
        List<Customer> customers = new ArrayList<>();
        CustomerManagementIplm customerManagementIplm = new CustomerManagementIplm();
        IPersonService iPersonService = new CustomerManagementIplm();
        do {
            checkChoice = false;
            System.out.println(ALIGNMENT +"1. Display list customers");
            System.out.println(ALIGNMENT +"2. Add new customers");
            System.out.println(ALIGNMENT +"3. Edit customers");
            System.out.println(ALIGNMENT +"4. Return main menu");
            System.out.println();
            System.out.println(ALIGNMENT +"(^_^)___________(^_^)");
            System.out.println(ALIGNMENT +"Enter your selection");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(ALIGNMENT +"look at the list carefully");
                checkChoice = true;
                continue;
            }
            switch (choice) {
                case 1:
                    customerManagementIplm.display();
                    checkChoice = true;
                    continue;
                case 2:
                    customerManagementIplm.addNew();
                    checkChoice = true;
                    continue;
                case 3:
                    customerManagementIplm.edit();
                    checkChoice = true;
                    continue;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println(ALIGNMENT +"look at the list carefully");
                    checkChoice = true;
                    continue;
            }
        } while (checkChoice);
    }

        static void facilityManagement(){
            FacilityManagementIplm facilityManagementIplm = new FacilityManagementIplm();
            do {
                checkChoice = false;
                System.out.println(ALIGNMENT +"1. Display list facility");
                System.out.println(ALIGNMENT +"2. Add new facility");
                System.out.println(ALIGNMENT +"3. Display maintenance facility");
                System.out.println(ALIGNMENT +"4. Return main menu");
                System.out.println();
                System.out.println(ALIGNMENT +"(^_^)___________(^_^)");
                System.out.println(ALIGNMENT +"Enter your selection");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println(ALIGNMENT +"look at the list carefully");
                    checkChoice = true;
                    continue;
                }
                switch (choice){
                    case 1:
                        do {
                            checkChoice = false;
                            System.out.println(ALIGNMENT +"1. Display Villa");
                            System.out.println(ALIGNMENT +"2. Display House");
                            System.out.println(ALIGNMENT +"3. Display Room");
                            System.out.println(ALIGNMENT +"4. Return main menu");
                            System.out.println(ALIGNMENT +"(^_^)___________(^_^)");
                            System.out.println(ALIGNMENT +"Enter your selection");
                            try {
                                choice = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println(ALIGNMENT + "look at the list carefully");
                                checkChoice = true;
                                continue;
                            }
                            switch(choice){
                                case 1:
                                    facilityManagementIplm.displayVilla(1);
                                    checkChoice = true;
                                    continue;
                                case 2:
                                    facilityManagementIplm.displayHouse(2);
                                    checkChoice = true;
                                    continue;
                                case 3:
                                    facilityManagementIplm.displayRoom(3);
                                    checkChoice = true;
                                    continue;
                                case 4:
                                    facilityManagement();
                                    break;

                                default:
                                    System.out.println(ALIGNMENT +"look at the list carefully");
                                    checkChoice = true;
                                    continue;
                            }
                        }while (checkChoice);
                        checkChoice = true;
                        continue;
                    case 2:
                        do {
                            checkChoice = false;
                            System.out.println(ALIGNMENT +"1. Add New Villa");
                            System.out.println(ALIGNMENT +"2. Add New House");
                            System.out.println(ALIGNMENT +"3. Add New Room");
                            System.out.println(ALIGNMENT +"4. Return main menu");
                            System.out.println(ALIGNMENT +"(^_^)___________(^_^)");
                            System.out.println(ALIGNMENT +"Enter your selection");
                            try {
                                choice = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println(ALIGNMENT + "look at the list carefully");
                                checkChoice = true;
                                continue;
                            }
                                switch(choice){
                                    case 1:
                                        facilityManagementIplm.addNew(1);
                                        checkChoice = true;
                                        continue;
                                    case 2:
                                        facilityManagementIplm.addNew(2);
                                        checkChoice = true;
                                        continue;
                                    case 3:
                                        facilityManagementIplm.addNew(3);
                                        checkChoice = true;
                                        continue;
                                    case 4:
                                        facilityManagement();
                                        break;

                                    default:
                                        System.out.println(ALIGNMENT +"look at the list carefully");
                                        checkChoice = true;
                                        continue;
                                }
                        }while (checkChoice);
                        checkChoice = true;
                        continue;
                    case 3:
                        facilityManagementIplm.displayListMaintainance();
                        checkChoice = true;
                        continue;
                    case 4:
                        displayMainMenu();
                        break;
                    default:
                        System.out.println(ALIGNMENT +"look at the list carefully");
                        checkChoice = true;
                        continue;
                }
            } while (checkChoice);

    }

    static void bookingManagement(){
        BookingManagermentIplm bookingManagermentIplm = new BookingManagermentIplm();
        do {
            checkChoice = false;
            System.out.println(ALIGNMENT +"1. Add new booking");
            System.out.println(ALIGNMENT +"2. Display list booking");
            System.out.println(ALIGNMENT +"3. Create new contracts");
            System.out.println(ALIGNMENT +"4. Display list contract");
            System.out.println(ALIGNMENT +"5. Edit contract");
            System.out.println(ALIGNMENT +"6. Return main menu");
            System.out.println();
            System.out.println(ALIGNMENT +"(^_^)___________(^_^)");
            System.out.println(ALIGNMENT +"Enter your selection");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(ALIGNMENT +"look at the list carefully");
                checkChoice = true;
                continue;
            }
            switch (choice){
                case 1:
                    bookingManagermentIplm.addNewBooking();
                    checkChoice = true;
                    continue;
                case 2:
                    bookingManagermentIplm.displayLístBooking();
                    checkChoice = true;
                    continue;
                case 3:
                    //
                    checkChoice = true;
                    continue;
                case 4:
                    //
                    checkChoice = true;
                    continue;
                case 5:
                    //
                    checkChoice = true;
                    continue;
                case 6:
                    displayMainMenu();
                    break;

                default:
                    System.out.println(ALIGNMENT +"look at the list carefully");
                    checkChoice = true;
                    continue;
            }
        } while (checkChoice);

    }

    static void promotionManagement(){
        do {
            checkChoice = false;
            System.out.println(ALIGNMENT +"1. Display list customers use service");
            System.out.println(ALIGNMENT +"2. Display list customers get voucher");
            System.out.println(ALIGNMENT +"3. Return main menu");
            System.out.println();
            System.out.println(ALIGNMENT +"(^_^)___________(^_^)");
            System.out.println(ALIGNMENT +"Enter your selection");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(ALIGNMENT +"look at the list carefully");
                checkChoice = true;
                continue;
            }
            switch (choice){
                case 1:
                    //
                    checkChoice = true;
                    continue;
                case 2:
                    //
                    checkChoice = true;
                    continue;
                case 3:
                    displayMainMenu();
                    break;
                default:
                    System.out.println(ALIGNMENT +"look at the list carefully");
                    checkChoice = true;
                    continue;
            }
        } while (checkChoice);

    }

}
