package Advanced_Programming_with_Java_2_1.ss11_DSA_Stack_Queue.Bai_tap;

import java.util.Stack;

public class ReverseStackString {
    public static void main(String[] args) {
        String mWork = "Hồ Nhật Hiếu";
        Stack<Character> wStack = new Stack<>();
        for (int i = 0; i < mWork.length(); i++){
            wStack.push(mWork.charAt(i));
        }
        System.out.println(mWork);


        String newMWork = "";
        for (int i = 0; i < mWork.length(); i++){
            newMWork += wStack.pop();
        }
        System.out.println(newMWork);
    }
}
