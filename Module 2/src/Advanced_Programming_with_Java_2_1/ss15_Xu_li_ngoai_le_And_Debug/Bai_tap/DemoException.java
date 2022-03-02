package Advanced_Programming_with_Java_2_1.ss15_Xu_li_ngoai_le_And_Debug.Bai_tap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoException {
    public static void check() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int str = scanner.nextInt();


            try {
                if ("admin".equals(str)) {
                    throw new MyException();
                }
            }catch (Exception e){
                e.printStackTrace();

            }
        }

    public static void main(String[] args) {
        try {
            check();
        }catch (MyException e){
            e.printStackTrace();
        } catch (InputMismatchException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }





