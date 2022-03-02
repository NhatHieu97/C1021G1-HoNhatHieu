package Advanced_Programming_with_Java_2_1.ss17_IO_Binary_File_And_Serialization.Bai_tap.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextProduct {


    public static void main(String[] args)  {
        List<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        IProduct iProduct = new ProductIpl();
        iProduct.writeToFile();


        int select = 0;
        do{
            System.out.println("\"--Product Menu--\"");
            System.out.println("1. Print List all");
            System.out.println("2. Add new");
            System.out.println("3. SearchName");
            select = Integer.parseInt(scanner.nextLine());
            switch (select){
                case 1:
                    iProduct.findAll();
                    products = iProduct.readToFile();
                    break;
                case 2:
                    iProduct.add();
                    iProduct.writeToFile();
                    break;
                case 3:
                    iProduct.search();
                    break;
                default:
                    System.out.println("input err!");
            }
        }while (select!=9);


    }

}
