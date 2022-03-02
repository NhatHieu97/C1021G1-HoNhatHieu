package Advanced_Programming_with_Java_2_1.ss17_IO_Binary_File_And_Serialization.Bai_tap.Product;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String brand;
    private String price;



    public Product(String id, String name, String brand, String price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
