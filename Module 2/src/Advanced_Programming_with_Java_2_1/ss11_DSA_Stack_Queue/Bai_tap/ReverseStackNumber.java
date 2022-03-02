package Advanced_Programming_with_Java_2_1.ss11_DSA_Stack_Queue.Bai_tap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseStackNumber {
    public static void main(String[] args) {
        Stack<Integer> listStack = new Stack<>();
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        listStack.push(4);
        listStack.push(5);
        List<Integer> newListStack = new ArrayList<>();
        while (!listStack.isEmpty()){
            newListStack.add(listStack.pop());
        }
        System.out.println(newListStack);

    }


}
