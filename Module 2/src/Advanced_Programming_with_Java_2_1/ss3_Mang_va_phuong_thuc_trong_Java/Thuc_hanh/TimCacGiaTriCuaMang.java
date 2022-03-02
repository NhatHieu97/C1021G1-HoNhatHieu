package Advanced_Programming_with_Java_2_1.ss3_Mang_va_phuong_thuc_trong_Java.Thuc_hanh;

import java.util.Scanner;

public class TimCacGiaTriCuaMang {
    public static void main(String[] args) {
        System.out.println("Tìm các giá trị của mảng: ");
        
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a name's students: ");
        String inputName = input.nextLine();
        
        boolean isExist = false;
        for (int i = 0; i < students.length; i++){
            if(students[i].equals(inputName))
                System.out.println("Position of the students in the list " + inputName + " is: " + i);
                isExist = true;
                break;
        }
        if (!isExist){
            System.out.println("Not found" + inputName + " in the list.");
        }
    }
}
