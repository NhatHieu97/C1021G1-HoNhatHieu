package Advanced_Programming_with_Java_2_1.ss17_IO_Binary_File_And_Serialization.Bai_tap.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProductIpl implements IProduct {
    public static final String PRODUCTTEXT = "E:\\Codegym\\Module 2\\src\\Advanced_Programming_with_Java_2_1\\ss17_IO_Binary_File_And_Serialization\\Bai_tap\\Product\\Product.txt";
    Scanner input = new Scanner(System.in);
    public static List<Product> product = new ArrayList<>();
    public static int random(){
        int numrd = 0;
        Random rd = new Random();
        numrd = rd.nextInt(9);
        return numrd;
    }
    public static String numRandom(){
        String result = "";
        for (int i =0;i < 3;i++){
            result += (random() + "");
        }
        return result;
    }
    static {
        product.add(new Product(numRandom(), "Nước ngọt", "Hà Nội", "7000"));
        product.add(new Product(numRandom(), "Trà đá", "Hà Nội", "8000"));
        product.add(new Product(numRandom(), "Mỳ tôm", "Đà Nẵng", "9000"));
        product.add(new Product(numRandom(), "Cơm gà", "Hà Nội", "10000"));
    }



    public void writeToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PRODUCTTEXT);
            ObjectOutputStream objectInputStream = new ObjectOutputStream(fileOutputStream);
            objectInputStream.writeObject(product);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Product> readToFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream(PRODUCTTEXT);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            product = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void search() {
        System.out.println("Input Name:");
        String NameProduct = input.nextLine();
        boolean check = false;
        for (int i = 0; i < product.size(); i++){
            if(product.get(i).getName().equals(NameProduct)){
                System.out.println(product.get(i));
                check = true;
                break;
            }
        }if (check){
            System.out.println("Product have not");
        }

    }
    @Override
    public void findAll() {
        for (Product products : product){
            System.out.println(products);
        }
    }

    @Override
    public void add() {

        System.out.println("Input NameProduct: ");
        String nameProduct = input.nextLine();
        System.out.println("Input Brand: ");
        String brand = input.nextLine();
        System.out.println("Input PriceProduct: ");
        String priceProduct = input.nextLine();
        Product newProduct = new Product(numRandom(), nameProduct, brand, priceProduct);
        product.add(newProduct);

    }



    }



