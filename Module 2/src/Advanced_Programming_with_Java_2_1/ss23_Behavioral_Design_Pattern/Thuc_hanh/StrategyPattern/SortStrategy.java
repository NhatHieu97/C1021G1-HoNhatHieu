package ss23_Behavioral_Design_Pattern.Thuc_hanh.StrategyPattern;

import java.util.List;

public interface SortStrategy {
    <T> void sort(List<T> items);
}
