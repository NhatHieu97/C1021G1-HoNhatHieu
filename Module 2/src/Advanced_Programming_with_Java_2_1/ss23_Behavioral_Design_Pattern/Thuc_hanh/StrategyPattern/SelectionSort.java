package ss23_Behavioral_Design_Pattern.Thuc_hanh.StrategyPattern;

import java.util.List;

public class SelectionSort implements SortStrategy{
    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Selection Sort");
    }
}
