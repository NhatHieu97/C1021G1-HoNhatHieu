package Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_2.Service;

import Advanced_Programming_with_Java_2_1.ss24_BaiTapLamThemHuongDuong.Bai_2.Student;

import java.util.List;

public interface StudentService {
    void add (Student student);
    List<Student> findAll();
    void remove(int id);
    void removeIndex(int index);
    void search(String mssv);

}
