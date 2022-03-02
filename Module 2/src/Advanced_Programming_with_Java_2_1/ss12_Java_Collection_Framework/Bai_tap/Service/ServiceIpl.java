package Advanced_Programming_with_Java_2_1.ss12_Java_Collection_Framework.Bai_tap.Service;

import Advanced_Programming_with_Java_2_1.ss12_Java_Collection_Framework.Bai_tap.ControlProduct;
import Advanced_Programming_with_Java_2_1.ss12_Java_Collection_Framework.Bai_tap.Product;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

public class ServiceIpl implements IService {
    Scanner input = new Scanner(System.in);
    public static List<Product> productList = new ArrayList<>();

    static {
        Product product1 = new Product(1,"Mì tôm",5000.0);
        Product product2 = new Product(2,"Nước lọc",10000.0);
        productList.add(product1);
        productList.add(product2);
    }



    @Override
    public void add() {
        System.out.println("Input ID: ");
        int inputID = Integer.parseInt(input.nextLine());
        System.out.println("Input NameProduct: ");
        String NameProduct = input.nextLine();
        System.out.println("Input PriceProduct: ");
        double PriceProduct = Double.parseDouble(input.nextLine());
        Product newProduct = new Product(inputID, NameProduct, PriceProduct);
        productList.add(newProduct);
    }

    @Override
    public void findAll() {
        for (Product product: productList){
            System.out.println(product);
        }

    }

    @Override
    public void fix() {
        System.out.println("Input ID: ");
        int fixProduct = Integer.parseInt(input.nextLine());
        for (int i = 0; i < productList.size(); i++){
            if(productList.get(i).getId() == fixProduct){
                System.out.println("Input Name: ");
                String NameProduct = input.nextLine();
                System.out.println("Input PriceProduct: ");
                double PriceProduct = Double.parseDouble(input.nextLine());
                productList.get(i).setName(NameProduct);
                productList.get(i).setPrice(PriceProduct);
            }
        }
    }

    @Override
    public void remove() {
        System.out.println("Input ID: ");
        int searchID = Integer.parseInt(input.nextLine());
        for (int i = 0; i < productList.size(); i++){
            if(productList.get(i).getId() == searchID){
                productList.remove(i);
            }
        }
    }

    @Override
    public void sortIncrease() {
        Collections.sort(productList);
    }

    @Override
    public void sortDcrease() {
        Product product = new Product();
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

    }

    @Override
    public void search() {
        System.out.println("Input Name: ");
        String NameProduct = input.nextLine();
        boolean check = false;
        for (int i = 0; i < productList.size(); i++){
            if(productList.get(i).getName().equals(NameProduct)){
                System.out.println(productList.get(i));
                check = true;
                break;
            }
        }if (check){
            System.out.println("Product have not");
        }
    }




}
