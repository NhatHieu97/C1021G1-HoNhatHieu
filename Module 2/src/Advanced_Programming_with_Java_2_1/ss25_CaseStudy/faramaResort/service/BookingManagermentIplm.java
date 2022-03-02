package Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.service;

import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.Agreement.Booking;
import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.facility.Facility;
import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.facility.House;
import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.facility.Room;
import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.facility.Villa;
import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.person.Customer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class BookingManagermentIplm implements IBookingService {
    public static final String CUSTOMER_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss25_CaseStudy\\faramaResort\\data\\customerProfileReadWrite.csv";
    public static final String VILLA_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss25_CaseStudy\\faramaResort\\data\\villaProfileReadWrite.csv";
    public static final String HOUSE_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss25_CaseStudy\\faramaResort\\data\\houseProfileWriteRead.csv";
    public static final String ROOM_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss25_CaseStudy\\faramaResort\\data\\roomProfileReadWrite.csv";
    Scanner scanner = new Scanner(System.in);
    public static List<Customer> customerList = new ArrayList<>();
    public static List<Facility> facilityList = new ArrayList<>();
    public static Set<Booking> bookingList = new TreeSet<>();

    static {
        readFromFile();
        readFromFileVilla();
        readFromFileHouse();
        readFromFileRoom();
    }


    public static void readFromFile() {
        try {
            FileReader fileReader = new FileReader(CUSTOMER_PROFILE);
            BufferedReader bufferedReader = new BufferedReader((fileReader));
            String line;
            String temp[];
            Customer customer;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                customer = new Customer(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
                customerList.add(customer);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFileVilla() {
        try {
            FileReader fileReaderVilla = new FileReader(VILLA_PROFILE);
            BufferedReader bufferedReaderVilla = new BufferedReader(fileReaderVilla);
            String line;
            String temp[];
            Villa villa = null;
            while ((line = bufferedReaderVilla.readLine()) != null) {
                temp = line.split(",");
                villa = new Villa(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]),
                        temp[5], temp[6], Double.parseDouble(temp[7]), Integer.parseInt(temp[8]));
                facilityList.add(villa);
            }
            bufferedReaderVilla.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFileHouse() {
        try {
            FileReader fileReaderHouse = new FileReader(HOUSE_PROFILE);
            BufferedReader bufferedReaderHouse = new BufferedReader(fileReaderHouse);
            String line;
            String temp[];
            House house = null;
            while ((line = bufferedReaderHouse.readLine()) != null) {
                temp = line.split(",");
                house = new House(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]),
                        temp[5], temp[6], Integer.parseInt(temp[7]));
                facilityList.add(house);
            }
            bufferedReaderHouse.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFileRoom() {
        try {
            FileReader fileReaderRoom = new FileReader(ROOM_PROFILE);
            BufferedReader bufferedReaderRoom = new BufferedReader(fileReaderRoom);
            String line;
            String temp[];
            Room room = null;
            while ((line = bufferedReaderRoom.readLine()) != null) {
                temp = line.split(",");
                room = new Room(temp[0], temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]),
                        temp[5], temp[6]);
                facilityList.add(room);

            }
            bufferedReaderRoom.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewBooking() {
        boolean check;
        String inputIdContract;
        String inputIdCustomer;
        String inputBeginDay;
        String inputEndDate;
        String inputNameService;
        String inputServiceType;
        String now = LocalDate.now() + "";
        String arrayNow[] = now.split("-");
        long beginToMilliseconds = 0;
        long endToMilliseconds = 0;
        long nowToMilliseconds = new Date(Integer.parseInt(arrayNow[0]), Integer.parseInt(arrayNow[1]), Integer.parseInt(arrayNow[2])).getTime();

        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        do {
            check = true;
            System.out.println("INPUT ID CUSTOMER: ");
            inputIdCustomer = scanner.nextLine();
            for (Customer customers : customerList) {
                if (inputIdCustomer.equals(customers.getId())) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println("ERROR FOMMAT ID CUSTOMER");
            }
        } while (check);

        System.out.println("INPUT ID CONTRACT: ");
        inputIdContract = scanner.nextLine();
        do {
            check = false;
            System.out.println("INPUT BEGIN DAY: ");
            inputBeginDay = scanner.nextLine();
            if (testTime(inputBeginDay)) {
                String arrayBegin[] = inputBeginDay.split("/");
                beginToMilliseconds = new Date(Integer.parseInt(arrayBegin[2]), Integer.parseInt(arrayBegin[1]), Integer.parseInt(arrayBegin[0])).getTime();
                if (beginToMilliseconds - nowToMilliseconds < 0) {
                    System.out.println("THIS TIME IS LESS THAN CURERENT, PLEASE INPUT AGAIN");
                    check = true;
                    continue;
                } else {
                    check = false;
                    break;
                }
            } else {
                check = true;
            }
        } while (check);

        do {
            check = false;
            System.out.println("INPUT END DATE: ");
            inputEndDate = scanner.nextLine();

            if (testTime(inputEndDate)) {
                String arrayEnd[] = inputEndDate.split("/");
                endToMilliseconds = new Date(Integer.parseInt(arrayEnd[2]), Integer.parseInt(arrayEnd[1]), Integer.parseInt(arrayEnd[0])).getTime();
                if (endToMilliseconds - beginToMilliseconds < 0) {
                    System.out.println("THIS TIME IS LESS THAN CURERENT, PLEASE INPUT AGAIN");
                    check = true;
                    continue;
                } else {
                    check = false;
                    break;
                }
            } else {
                check = true;
            }
        } while (check);

        do {
            check = true;
            System.out.println("INPUT SERVICE TYPE: VILLA, HOUSE, ROOM ");
            inputServiceType = scanner.nextLine();
            if (inputServiceType.toLowerCase().equals("villa")){
                check = false;
                break;
            }else if (inputServiceType.toLowerCase().equals("house")){
                check = false;
                break;
            }else if(inputServiceType.toLowerCase().equals("room")){
                check = false;
                break;
            }
            if (check){
                System.out.println("ERROR TYPE SERVICE: PLEASE BE A SMART PERSON ");
            }
        }while (check);


        for (Facility facility : facilityList) {
            System.out.println(facility);
        }
        do {
            check = true;
            System.out.println("INPUT NAME SERVICE: ");
            inputNameService = scanner.nextLine();
            for (Facility facility : facilityList) {
                if (inputNameService.toLowerCase().equals(facility.getServiceName().toLowerCase())) {
                    if (facility instanceof Villa) {
                        Villa villa = (Villa) facility;
                        check = false;
                        break;
                    } else if (facility instanceof House) {
                        House house = (House) facility;
                        check = false;
                        break;
                    } else {
                        Room room = (Room) facility;
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                System.out.println("ERROR FORMAT SERVICE DAY: ");
            }
        } while (check);
        Booking booking = new Booking(inputIdContract, inputBeginDay, inputEndDate, inputIdCustomer, inputNameService, inputServiceType);
        bookingList.add(booking);
    }


    @Override
    public void displayLístBooking() {
        for (Booking booking: bookingList){
            System.out.println(booking);
        }


    }

    @Override
    public void createNewConstract() {

    }

    @Override
    public void displayListConstract() {

    }

    @Override
    public void editConstract() {

    }

    public boolean testTime(String date) {
        String regexDate = "[0-9]{1,2}/[0-9]{1,2}/(20|19)[0-9]{2}";

        if (date.matches(regexDate)) {
            String[] temp = date.split("/");
            if (Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 12) {
                return false;
            }
            if (Integer.parseInt(temp[1]) == 1 || Integer.parseInt(temp[1]) == 3 || Integer.parseInt(temp[1]) == 5 || Integer.parseInt(temp[1]) == 7 ||
                    Integer.parseInt(temp[1]) == 8 || Integer.parseInt(temp[1]) == 10 || Integer.parseInt(temp[1]) == 12) {
                if (Integer.parseInt(temp[0]) < 0 || Integer.parseInt(temp[0]) > 31) {
                    return false;
                }
            } else if (Integer.parseInt(temp[1]) == 2) {
                if ((Integer.parseInt(temp[2]) % 4 == 0 && Integer.parseInt(temp[2]) % 100 != 0) || Integer.parseInt(temp[2]) % 400 == 0) {
                    if (Integer.parseInt(temp[1]) < 0 || Integer.parseInt(temp[1]) > 29) {
                        return false;
                    }
                } else {
                    if (Integer.parseInt(temp[0]) < 0 || Integer.parseInt(temp[0]) > 28) {
                        return false;
                    }
                }
            } else if (Integer.parseInt(temp[1]) > 0 || Integer.parseInt(temp[1]) < 13) {
                if (Integer.parseInt(temp[0]) < 0 || Integer.parseInt(temp[0]) > 30) {
                    return false;
                }
            }
            return true;
        }return false;
    }
}
