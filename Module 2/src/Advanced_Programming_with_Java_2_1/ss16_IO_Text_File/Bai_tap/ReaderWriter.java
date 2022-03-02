package Advanced_Programming_with_Java_2_1.ss16_IO_Text_File.Bai_tap;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ReaderWriter {

    public static final String fileRead = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss16_IO_Text_File\\Bai_tap\\source.txt";
    public static final String fileWirte = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss16_IO_Text_File\\Bai_tap\\target .txt";

    public static String readFile(){
        String result = "";
        File fileRead1 = new File(fileRead);
        File fileWirter1 = new File(fileWirte);

        try {
            if (!fileRead1.exists()) {
                throw new FileNotFoundException();
            }
            if (!fileWirter1.exists()) {
                throw new FileNotFoundException();
            }

            FileReader fileReader = new FileReader(fileRead1);
            FileWriter fileWriter = new FileWriter(fileWirter1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while ((result = bufferedReader.readLine()) != null){
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        readFile();
    }

}
