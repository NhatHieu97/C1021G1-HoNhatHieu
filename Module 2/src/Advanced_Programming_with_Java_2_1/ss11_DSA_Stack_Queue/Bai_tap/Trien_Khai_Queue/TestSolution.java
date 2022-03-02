package Advanced_Programming_with_Java_2_1.ss11_DSA_Stack_Queue.Bai_tap.Trien_Khai_Queue;

public class TestSolution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Queue q = new Queue();
        q.front = q.rear = null;

        solution.enQueue(q, 14);
        solution.enQueue(q, 22);
        solution.enQueue(q, 6);

        solution.displayQueue(q);

        System.out.printf(" Deleted value = %d", solution.deQueue(q));
        System.out.printf(" Deleted value = %d", solution.deQueue(q));

        solution.displayQueue(q);

        solution.enQueue(q, 9);
        solution.enQueue(q, 20);
        solution.displayQueue(q);
    }
}
