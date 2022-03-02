package Advanced_Programming_with_Java_2_1.ss12_Java_Collection_Framework.Bai_tap;

import java.util.Comparator;

public class Product implements Comparable<Product>, Comparator<Product> {
    private int id;
    private String name;
    private Double price;

    public Product() {
    }

    public Product(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ControlProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if(this.price - o.getPrice() > 0){
            return 1;
        }else if (this.price - o.getPrice() < 0){
            return -1;
        }else
            return 0;
    }

    @Override
    public int compare(Product o1, Product o2) {
        if(o1.price - o2.getPrice() > 0){
            return -1;
        }else if (o1.price - o2.getPrice() < 0){
            return 1;
        }else
            return 0;
    }
}
