package Advanced_Programming_with_Java_2_1.ss14_Thuat_toan_sap_xep.Bai_tap;

import java.util.Scanner;

public class sortInsert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size: ");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values: ");
        for (int i = 0; i < list.length; i++) {
            System.out.println("The element " + i);
            list[i] = scanner.nextInt();
        }
        System.out.println("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println("\nBegin sort processing...");
        insertSort(list);
    }
    public static void insertSort(int[] list){
        int pos,x;

        for(int i = 1; i < list.length; i++){
            x = list[i];
            pos = i;
            while (pos > 0 && x < list[pos - 1]){

                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = x;
        }
        System.out.print("The list element sort: ");
        for (int arrs: list){
            System.out.print(arrs + "\t");
        }

    }

}
