package Advanced_Programming_with_Java_2_1.ss12_Java_Collection_Framework.Thuc_hanh.Comparable_Comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAge() > o2.getAge()){
            return 1;
        }else if(o1.getAge() == o2.getAge()){
            return 0;
        }else{
            return -1;
        }
    }
    }

