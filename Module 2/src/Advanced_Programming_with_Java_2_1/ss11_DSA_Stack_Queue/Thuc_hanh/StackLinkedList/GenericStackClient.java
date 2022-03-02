package Advanced_Programming_with_Java_2_1.ss11_DSA_Stack_Queue.Thuc_hanh.StackLinkedList;

public class GenericStackClient {
    public static void main(String[] args) {
        MyGenericStack myGenericStack = new MyGenericStack();
        System.out.println("1. Stack of integers");
        myGenericStack.stackOfIntegers();
        System.out.println("\n2. Stack of Strings");
        myGenericStack.stackOfIStrings();
    }



}
