package Advanced_Programming_with_Java_2_1.ss16_IO_Text_File.Thuc_hanh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public static final String fileMax = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss16_IO_Text_File\\Thuc_hanh\\numbers.txt";
    public static final String fileResult = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss16_IO_Text_File\\Thuc_hanh\\result.txt";

    public List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return numbers;
    }
    public void WiterFile(String filePath, int max){
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Giá trị lớn nhất là: " + max);
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int findMax(List<Integer> number) {
        int max = number.get(0);
        for (int i = 0; i < number.size(); i++){
            if (max < number.get(i)){
                max = number.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List <Integer> numbers = readAndWriteFile.readFile(fileMax);
        int maxValue = findMax(numbers);
        readAndWriteFile.WiterFile(fileResult, maxValue);
    }
}
