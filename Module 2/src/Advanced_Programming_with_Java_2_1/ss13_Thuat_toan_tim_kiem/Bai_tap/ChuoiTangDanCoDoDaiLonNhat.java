package Advanced_Programming_with_Java_2_1.ss13_Thuat_toan_tim_kiem.Bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class ChuoiTangDanCoDoDaiLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input String: ");
        String str = scanner.nextLine();
        String result = "";

        int code = (int)str.charAt(0);
        for (int i = 0; i < str.length(); i++){
            int currentCode = (int)str.charAt(i);
            System.out.println(currentCode);
            if(code <= currentCode){
                result += str.charAt(i);
                code = currentCode;
            }
        }
        System.out.println(result);





//        LinkedList<Character> max = new LinkedList<>();
//        for (int i = 0; i < str.length(); i++){
//            LinkedList<Character> list = new LinkedList<>();
//            list.add(str.charAt(i));
//
//            for (int j = i + 1; j < str.length(); j++){
//                if(str.charAt(j) > list.getLast()){
//                    list.add(str.charAt(j));
//                }
//            }
//             if (list.size() > max.size()){
//                 max.clear();
//                 max.addAll(list);
//             }
//             list.clear();
//        }
//        for (Character character : max){
//            System.out.print(character);
//        }

    }
}
