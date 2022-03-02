package Advanced_Programming_with_Java_2_1.ss10_DSA_Danh_sach.Thuc_hanh.Trien_Khai_Lop_LinkedList_Đon_Gian;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList();
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(4,9);
        ll.add(4,9);
        ll.printList();
    }
}
