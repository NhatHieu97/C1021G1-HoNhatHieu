package Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.service;

import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.facility.Facility;
import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.facility.House;
import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.facility.Room;
import Advanced_Programming_with_Java_2_1.ss25_CaseStudy.faramaResort.models.facility.Villa;

import java.io.*;
import java.util.*;

public class FacilityManagementIplm implements IFacilityService {
    public static final String VILLA_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss25_CaseStudy\\faramaResort\\data\\villaProfileReadWrite.csv";
    public static final String HOUSE_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss25_CaseStudy\\faramaResort\\data\\houseProfileWriteRead.csv";
    public static final String ROOM_PROFILE = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss25_CaseStudy\\faramaResort\\data\\roomProfileReadWrite.csv";
    static Scanner scanner = new Scanner(System.in);
    public static Map<Facility,Integer> facilityList= new LinkedHashMap<Facility,Integer>();
    static {
        readHashMap();
        if(facilityList.size() == 0){
            Villa villa = new Villa("SVVL-" + numRamdom(), "oceanvilla", 35.0, 4000, 6 , "year", "vip", 35.0, 3);
            House house = new House("SVHO-" + numRamdom(), "luxuryhouse", 35.0, 4000, 7 , "year", "vip", 3);
            Room room  = new Room("SVVL-" + numRamdom(), "viproom", 35.0, 4000, 12 , "year", "tea");
            facilityList.put(villa,1);
            facilityList.put(house,1);
            facilityList.put(room,1);
            writeFile();
        }

    }
    public static void readHashMap(){
        for (Map.Entry<Facility,Integer> entry: readFromFileVilla().entrySet()){
            facilityList.put(entry.getKey(),1);
        }
        for (Map.Entry<Facility,Integer> entry: readFromFileHouse().entrySet()){
            facilityList.put(entry.getKey(),1);
        }
        for (Map.Entry<Facility,Integer> entry: readFromFileRoom().entrySet()){
            facilityList.put(entry.getKey(),1);
        }


    }
    public FacilityManagementIplm(){
        readHashMap();
    }
    public static int ramdom(){
        int numrd = 0;
        Random rd = new Random();
        numrd = rd.nextInt(9);
        return numrd;
    }
    public static String numRamdom() {
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += (ramdom() + "");
        }
        return result;
    }
    @Override
    public void displayListMaintainance() {
        for (Map.Entry<Facility,Integer> facilityIntegerEntry : facilityList.entrySet()){
            if (facilityIntegerEntry.getValue() > 4){
                if (facilityIntegerEntry.getKey() instanceof Villa){
                    System.out.println("The Villa is under maintenance, please come back later!!!!");
                }else if(facilityIntegerEntry.getKey()instanceof House){
                    System.out.println("The House is under maintenance, please come back later!!!!");
                }else {
                    System.out.println("The Room is under maintenance, please come back later!!!!");
                }
            }else {
                System.out.println("Has been used for 5 times, please maintain!!!");
            }
        }

    }

    void updateFacility(Facility facility){
        if(facilityList.containsKey(facility)){
            facilityList.put(facility,facilityList.get(facility)+1);
        }else facilityList.put(facility,1);
    }

    public void displayVilla(int a) {
        if (a == 1) {
            System.out.println("1: DISPLAY VILLA: ");
            for (Map.Entry<Facility, Integer> facility : facilityList.entrySet()) {
                if (facility.getKey() instanceof Villa) {
                    System.out.println(facility.getKey());
                    System.out.println("Number of uses Villa: " + facility.getValue());

                }
            }
        }
    }
    public void displayHouse(int b){
        if (b == 2) {
            System.out.println("2: DISPLAY HOUSE: ");
            for (Map.Entry<Facility, Integer> facility : facilityList.entrySet()) {
                if (facility.getKey() instanceof House) {
                    System.out.println(facility.getKey());
                    System.out.print("Number of uses House: " + facility.getValue());
                }
            }
        }
    }
    public void displayRoom(int c){
        if (c == 3) {
            System.out.println("3: DISPLAY ROOM: ");
            for (Map.Entry<Facility, Integer> facility : facilityList.entrySet()) {
                if (facility.getKey() instanceof House) {
                    System.out.println("Number of uses Room:  " + facility.getKey());
                }
            }
        }
    }
    @Override
    public void display() {
    }
    @Override
    public void addNew(int a) {
        boolean check;
        double inputUsageArea1 = 0;
        String inputServiceVilla;
        String inputServiceHouse;
        String inputServiceRoom;
        String inputRoomStardardVilla;
        double inputPoolArea = 0;
        String inputRoomStardardHouse;
        int inputQuantityOfFloorHouse = 0;
        int inputQuantityOfFloorVilla = 0;
        String inputFreeService;

        if(a == 1){
            String[] propetyFacility= createPropetyFacility();

            do {
                check = true;
                System.out.println("INPUT VILLA SERVICE: OCEAN VILLA, VILLAGE VILLA, ABOGO VILLA ");
                inputServiceVilla = scanner.nextLine();
                if (inputServiceVilla.toLowerCase().equals("oceanvilla")){
                    check = false;
                    break;
                }else if (inputServiceVilla.toLowerCase().equals("villagevilla")){
                    check = false;
                    break;
                }else if(inputServiceVilla.toLowerCase().equals("abogovilla")){
                    check = false;
                    break;
                }
                if (check){
                    System.out.println("ERROR VILLA SERVICE: PLEASE BE A SMART PERSON ");
                }
            }while (check);

            do {
                check = true;
                System.out.println("INPUT VILLA STANDARD: NORMAL, VIP, SUPERVIP ");
                inputRoomStardardVilla = scanner.nextLine();
                if(inputRoomStardardVilla.toLowerCase().equals("normal")){
                    check = false;
                    break;
                }else if(inputRoomStardardVilla.toLowerCase().equals("vip")){
                    check = false;
                    break;
                }else if(inputRoomStardardVilla.toLowerCase().equals("supervip")){
                    check = false;
                    break;
                }
                if (check){
                    System.out.println("ERROR VILLA STANDARD: PLEASE BE A SMART PERSON ");
                }
            }while (check);

            do {
                check = false;
                try {
                    System.out.println("INPUT POOL AREA: ");
                    inputPoolArea = Double.parseDouble(scanner.nextLine());
                }catch (NumberFormatException e){
                    System.out.println("ERROR POOL AREA: PLEASE BE A SMART PERSON ");
                    check = true;
                    continue;
                }
                if(inputPoolArea < 30){
                    System.out.println("ERROR POOL AREA: PLEASE BE A SMART PERSON ");
                    check = true;
                    continue;
                }
            }while (check);

            do {
                check = false;
                try {
                    System.out.println("INPUT QUANTITY OF FLOOR: ");
                    inputQuantityOfFloorVilla = Integer.parseInt(scanner.nextLine());

                }catch (NumberFormatException e){
                    System.out.println("ERROR FORMAT QUANTITY OF FLOOR: PLEASE BE A SMART PERSON ");
                    check = true;
                    continue;
                }

                if (inputQuantityOfFloorVilla < 0){
                    System.out.println("ERROR QUANTITY OF FLOOR: PLEASE BE A SMART PERSON ");
                    check = true;
                    continue;
                }
            }while (check);
            Villa villa = new Villa("SVVL-" + numRamdom() ,inputServiceVilla, Double.parseDouble(propetyFacility[0]),
                    Integer.parseInt(propetyFacility[1]), Integer.parseInt(propetyFacility[2]), propetyFacility[3],
                    inputRoomStardardVilla, inputPoolArea, inputQuantityOfFloorVilla);
            updateFacility(villa);
            writeFile();

        }
        if(a == 2){
            String[] propetyFacility= createPropetyFacility();

            do {
                check = true;
                System.out.println("INPUT HOUSE SERVICE: LUXURY HOUSE, GARDEN HOUSE, BANA HOUSE ");
                inputServiceHouse = scanner.nextLine();
                if (inputServiceHouse.toLowerCase().equals("luxuryhouse")){
                    check = false;
                    break;
                }else if (inputServiceHouse.toLowerCase().equals("gardenhouse")){
                    check = false;
                    break;
                }else if(inputServiceHouse.toLowerCase().equals("banahouse")){
                    check = false;
                    break;
                }
                if (check){
                    System.out.println("ERROR HOUSE SERVICE: PLEASE BE A SMART PERSON ");
                }
            }while (check);

            do {
                check = true;
                System.out.println("INPUT HOUSE STANDARD: NORMAL, VIP, SUPERVIP ");
                inputRoomStardardHouse = scanner.nextLine();
                if(inputRoomStardardHouse.toLowerCase().equals("normal")){
                    System.out.println("ERROR HOUSE STANDARD: PLEASE BE A SMART PERSON ");
                    check = false;
                    break;
                }else if(inputRoomStardardHouse.toLowerCase().equals("vip")){
                    check = false;
                    break;
                }else if(inputRoomStardardHouse.toLowerCase().equals("supervip")){
                    check = false;
                    break;
                }
                if (check){
                    System.out.println("ERROR HOUSE STANDARD: PLEASE BE A SMART PERSON ");
                }
            }while (check);

            do {
                check = false;
                try {
                    System.out.println("INPUT QUANTITY OF FLOOR: ");
                    inputQuantityOfFloorHouse = Integer.parseInt(scanner.nextLine());

                }catch (NumberFormatException e){
                    System.out.println("ERROR FORMAT QUANTITY OF FLOOR: PLEASE BE A SMART PERSON ");
                    check = true;
                    continue;
                }

                if (inputQuantityOfFloorHouse < 0){
                    System.out.println("ERROR QUANTITY OF FLOOR: PLEASE BE A SMART PERSON ");
                    check = true;
                    continue;
                }
            }while (check);

            House house = new House("SVHO-" + numRamdom(), "House", Double.parseDouble(propetyFacility[0]),
                    Integer.parseInt(propetyFacility[1]), Integer.parseInt(propetyFacility[2]), propetyFacility[3],
                    inputRoomStardardHouse, inputQuantityOfFloorHouse);
            System.out.println(house);
            updateFacility(house);
            writeFile();
        }
        if(a == 3){
            String[] propetyFacility= createPropetyFacility();

            do {
                check = true;
                System.out.println("INPUT ROOM SERVICE: VIP ROOM, NORMAL ROOM, LUXURY ROOM ");
                inputServiceRoom = scanner.nextLine();
                if (inputServiceRoom.toLowerCase().equals("viproom")){
                    check = false;
                    break;
                }else if (inputServiceRoom.toLowerCase().equals("normalroom")){
                    check = false;
                    break;
                }else if(inputServiceRoom.toLowerCase().equals("luxuryroom")){
                    check = false;
                    break;
                }
                if (check){
                    System.out.println("ERROR ROOM SERVICE: PLEASE BE A SMART PERSON ");
                }
            }while (check);

            do {
                check = true;
                String[] freeService = {"tea", "water", "have breakfast", "have dinner", "housekeeping"};
                System.out.println("INPUT FREE SERVICE: TEA, WATER, HAVE BREAKFAST, HAVE DINNER, HOUSEKEEPING ");
                inputFreeService = scanner.nextLine();
                for (String freeService1 : freeService) {
                    if (inputFreeService.toLowerCase().equals(freeService1)) {
                        check = false;
                        break;
                    }
                    if (check);
                    System.out.println("ERROR FREE SERVICE: PLEASE BE A SMART PERSON ");
                }
            }while (check);
            Room room = new Room("SVRO-" + numRamdom() ,inputServiceRoom, Integer.parseInt(propetyFacility[0]),
                    Integer.parseInt(propetyFacility[1]), Integer.parseInt(propetyFacility[2]), propetyFacility[3], inputFreeService);
            updateFacility(room);
            writeFile();
        }
    }
    public static String[] createPropetyFacility(){
        boolean check;
        double inputUsageArea = 0;
        int inputRent = 0;
        int inputMaxPeople = 0;
        String inputRentType;

        do {
            check = false;
            try {
                System.out.println("INPUT USAGE AREA: ");
                inputUsageArea = Double.parseDouble(scanner.nextLine());

            }catch (NumberFormatException e){
                System.out.println("ERROR FORMAT USAGE AREA: PLEASE BE A SMART PERSON ");
                check = true;
                continue;
            }
            if (inputUsageArea < 30){
                System.out.println("ERROR USAGE AREA: PLEASE BE A SMART PERSON ");
                check = true;
                continue;
            }
        }while (check);

        do {
            check = false;
            try {
                System.out.println("INPUT RENT: ");
                inputRent = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("ERROR FORMAT RENT: PLEASE BE A SMART PERSON ");
                check = true;
                continue;
            }
            if(inputRent < 0){
                System.out.println("ERROR USAGE AREA: PLEASE BE A SMART PERSON ");
                check = true;
                continue;
            }
        }while (check);

        do {
            check = true;
            try{
                System.out.println("INPUT MAX PEOPLE: ");
                inputMaxPeople = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("ERROR FORMAT MAX PEOPLE: PLEASE BE A SMART PERSON ");

            }
            if (inputMaxPeople > 0 && inputMaxPeople < 20){
                check = false;
                break;
            }
            if (check){
                System.out.println("ERROR MAX PEOPLE: PLEASE BE A SMART PERSON ");
            }
        }while (check);

        do {
            check = true;
            String[] rentType = {"year","month","day","hour"};
            System.out.println("INPUT RENT TYPE: YEAR, MONTH, DAY, HOUR ");
            inputRentType = scanner.nextLine();
            for (String rentType1 : rentType) {
                if (inputRentType.toLowerCase().equals(rentType1)) {
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.println("ERROR RENT TYPE: PLEASE BE A SMART PERSON ");
            }
        }while (check);
        String[] propetyFacility = {String.valueOf(inputUsageArea), String.valueOf(inputRent), String.valueOf(inputMaxPeople), inputRentType};
        return propetyFacility;
    }
    public static void writeFile() {
        try {
            FileWriter fileWriterVilla = new FileWriter(VILLA_PROFILE);
            FileWriter fileWriterHouse = new FileWriter(HOUSE_PROFILE);
            FileWriter fileWriterRoom = new FileWriter(ROOM_PROFILE);
            BufferedWriter bufferedWriterVilla = new BufferedWriter(fileWriterVilla);
            BufferedWriter bufferedWriterHouse = new BufferedWriter(fileWriterHouse);
            BufferedWriter bufferedWriterRoom = new BufferedWriter(fileWriterRoom);
            Map<Villa,Integer> villa = new LinkedHashMap<>();
            Map<House,Integer> house = new LinkedHashMap<>();
            Map<Room,Integer> room = new LinkedHashMap<>();
            for (Map.Entry<Facility, Integer> entry : facilityList.entrySet()) {
                if (entry.getKey() instanceof Villa) {
                    villa.put((Villa) entry.getKey(),entry.getValue());
                }else if (entry.getKey() instanceof  House){
                    house.put((House) entry.getKey(), entry.getValue());
                }else {
                    room.put((Room) entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry<Villa, Integer> entry : villa.entrySet()){
                bufferedWriterVilla.write(entry.getKey().getIdService() + "," + entry.getKey().getServiceName() + "," +
                        entry.getKey().getAreaUsable() + "," + entry.getKey().getRent() + "," + entry.getKey().getMaxPeople() + "," + entry.getKey().getRentType() + "," +
                        entry.getKey().getRoomStandard() + "," + entry.getKey().getPoolArea() + "," + entry.getKey().getQuantityOfFloor());
                bufferedWriterVilla.newLine();
            }
            bufferedWriterVilla.close();

            for (Map.Entry<House, Integer> entry: house.entrySet()){
                bufferedWriterHouse.write(entry.getKey().getIdService() + "," + entry.getKey().getServiceName() + "," +
                        entry.getKey().getAreaUsable() + "," + entry.getKey().getRent() + "," + entry.getKey().getMaxPeople() + "," + entry.getKey().getRentType() + "," +
                        entry.getKey().getRoomStandard() + "," + entry.getKey().getQuantityOfFloor());
                bufferedWriterHouse.newLine();
            }
            bufferedWriterHouse.close();

            for (Map.Entry<Room, Integer> entry : room.entrySet()){
                bufferedWriterRoom.write(entry.getKey().getIdService() + "," + entry.getKey().getServiceName() + "," +
                        entry.getKey().getAreaUsable() + "," + entry.getKey().getRent() + "," + entry.getKey().getMaxPeople() + "," + entry.getKey().getRentType() + "," +
                        entry.getKey().getFreeService());
                bufferedWriterRoom.newLine();
            }
            bufferedWriterRoom.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<Facility, Integer> readFromFileVilla(){
        Map<Facility,Integer> facilityIntegerMapVilla = new LinkedHashMap<>();
        try {
            FileReader fileReaderVilla = new FileReader(VILLA_PROFILE);
            BufferedReader bufferedReaderVilla = new BufferedReader(fileReaderVilla);
            String line;
            String temp[];
            Villa villa = null;
            while ((line = bufferedReaderVilla.readLine()) != null){
                temp = line.split(",");
                villa = new Villa(temp[0],temp[1],Double.parseDouble(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),
                        temp[5],temp[6],Double.parseDouble(temp[7]),Integer.parseInt(temp[8]));
            }
            bufferedReaderVilla.close();
            if (villa != null){
                facilityIntegerMapVilla.put(villa,1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilityIntegerMapVilla;
    }

    public static Map<Facility, Integer> readFromFileHouse(){
        Map<Facility,Integer> facilityIntegerMapHouse = new LinkedHashMap<>();
        try {
            FileReader fileReaderHouse = new FileReader(HOUSE_PROFILE);
            BufferedReader bufferedReaderHouse = new BufferedReader(fileReaderHouse);
            String line;
            String temp[];
            House house = null;
            while ((line = bufferedReaderHouse.readLine()) != null){
                temp = line.split(",");
                house = new House(temp[0],temp[1],Double.parseDouble(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),
                        temp[5],temp[6],Integer.parseInt(temp[7]));
            }
            bufferedReaderHouse.close();
            if (house != null){
                facilityIntegerMapHouse.put(house,1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilityIntegerMapHouse;
    }

    public static Map<Facility, Integer> readFromFileRoom(){
        Map<Facility,Integer> facilityIntegerMapRoom = new LinkedHashMap<>();
        try {
            FileReader fileReaderRoom = new FileReader(ROOM_PROFILE);
            BufferedReader bufferedReaderRoom = new BufferedReader(fileReaderRoom);
            String line;
            String temp[];
            Room room = null;
            while ((line = bufferedReaderRoom.readLine()) != null){
                temp = line.split(",");
                room = new Room(temp[0],temp[1],Double.parseDouble(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),
                        temp[5],temp[6]);
            }
            if (room != null){
                facilityIntegerMapRoom.put(room,1);
            bufferedReaderRoom.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilityIntegerMapRoom;
    }
}
