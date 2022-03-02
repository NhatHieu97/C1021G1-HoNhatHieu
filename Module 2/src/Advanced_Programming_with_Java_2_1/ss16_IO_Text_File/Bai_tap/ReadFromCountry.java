package Advanced_Programming_with_Java_2_1.ss16_IO_Text_File.Bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFromCountry {

    public static final String FIlE_COUNTRY_CVN = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss16_IO_Text_File\\Bai_tap\\FILE_CONTRY.CSV";

    public static List<Country> readCSV() {
        List<Country> countryList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FIlE_COUNTRY_CVN);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Country country;

            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                country = new Country(Integer.parseInt(temp[0]),temp[1],temp[2]);
                countryList.add(country);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countryList;

    }
//    public static void writeCSV(Country country)  {
//        try {
//            FileWriter fileWriter = new FileWriter(FIlE_COUNTRY_CVN,true);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(country.getId() + "," + country.getCode() + "," + country.getName());
//            bufferedWriter.newLine();
//            bufferedWriter.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        List <Country> countryLists = readCSV();
        for (Country country: countryLists){
            System.out.println(country.getName());
        }
    }

}
