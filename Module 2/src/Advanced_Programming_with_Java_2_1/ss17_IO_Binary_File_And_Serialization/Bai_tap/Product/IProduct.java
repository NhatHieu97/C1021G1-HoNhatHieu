package Advanced_Programming_with_Java_2_1.ss17_IO_Binary_File_And_Serialization.Bai_tap.Product;

import java.io.IOException;
import java.util.List;

public interface IProduct {
    void add();
    void writeToFile();
    List<Product> readToFile();
    void search();
    void findAll();



}
