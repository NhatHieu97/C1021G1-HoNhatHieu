package Advanced_Programming_with_Java_2_1.ss11_DSA_Stack_Queue.Bai_tap;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DemSoLuong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào 1 chuỗi");
        String str = scanner.nextLine();
        Character keys;
        Map<Character,Integer> treeMap = new TreeMap<>(); 
        for (int i = 0; i < str.length();i++){
            keys = str.charAt(i);
            if (treeMap.containsKey(keys)){
                int count = treeMap.get(keys);
                treeMap.put(keys,count + 1);
            }else {
                treeMap.put(keys,1);
            }
        }
        System.out.println(treeMap);
    }
    }

