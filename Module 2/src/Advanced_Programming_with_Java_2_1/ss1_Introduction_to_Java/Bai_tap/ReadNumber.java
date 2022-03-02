package Advanced_Programming_with_Java_2_1.ss1_Introduction_to_Java.Bai_tap;

import java.util.Scanner;

public class ReadNumber {
    static String read1To10(int number) {
        String str = "";
        switch (number) {
            case 1:
                str = "one";
                break;
            case 2:
                str = "two";
                break;
            case 3:
                str = "three";
                break;
            case 4:
                str = "four";
                break;
            case 5:
                str = "five";
                break;
            case 6:
                str = "six";
                break;
            case 7:
                str = "seven";
                break;
            case 8:
                str = "eight";
                break;
            case 9:
                str = "nine";
                break;
            case 10:
                str = "ten";
                break;
        }
        return str;
    }
    static String read11To19(int number) {
        String str = "";
        switch (number) {
            case 11:
                str = "eleven";
                break;
            case 12:
                str = "twelve";
                break;
            case 13:
                str = "thirteen";
                break;
            case 14:
                str = "forteen";
                break;
            case 15:
                str = "fifteen";
                break;
            case 16:
            case 17:
            case 18:
            case 19:
                int hangDonVi = number % 10;
                str = read1To10(hangDonVi) + "teen";
                break;
        }
        return str;
    }

    static String readNumberTy(int number) {
        String str = "";
        switch (number) {
            case 20:
                str = "twenty";
                break;
            case 30:
                str = "thirty";
                break;
            case 40:
                str = "forty";
                break;
            case 50:
                str = "fifty";
                break;
            case 60:
            case 70:
            case 80:
            case 90:
                int hangChuc = number / 10;
                str = read1To10(hangChuc) + "ty";
                break;
        }
        return str;
    }
    static String hundred(int number) {
        String str = "";
        switch (number) {
            case 100:
                str = "one hundred";
                break;
            case 200:
                str = "two hundred";
                break;
            case 300:
                str = "three hundred";
                break;
            case 400:
                str = "four hundred";
                break;
            case 500:
                str = "five hundred";
                break;
            case 600:
            case 700:
            case 800:
            case 900:
                int hangTram = number / 100;
                str = read1To10(hangTram) + "hundred";
                break;
        }
        return str;
    }
    public static void main(String[] args) {
        ReadNumber number1 = new ReadNumber();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input number: ");

        int number = scanner.nextInt();
        if (number > 0 && number <= 10){
            String result = number1.read1To10(number);
            System.out.println("Result: " + result);
        } else if (number > 10 && number < 20) {
            String result = number1.read11To19(number);
            System.out.println("Result: " + result);
        } else if(number >= 20 && number < 100) {
            int hangChuc = (number / 10) * 10;
            int hangDonVi = number % 10;

            String result = number1.readNumberTy(hangChuc) + " " + number1.read1To10(hangDonVi);
            System.out.println("Result: " + result);
        } else {
            int hangTram = (number / 100) * 100;
            int hangChuc = ((number % 100) / 10) * 10;
            int hangDonVi = ((number % 100) % 10);

            if (hangChuc > 19){
                String result = number1.hundred(hangTram) + " " + number1.readNumberTy(hangChuc) + " " + number1.read1To10(hangDonVi);
                System.out.println("Result: " + result);
            }else {
                String result = number1.hundred(hangTram) + " " + number1.read11To19(hangChuc + hangDonVi);
                System.out.println("Result: " + result);
            }
        }
    }

}
