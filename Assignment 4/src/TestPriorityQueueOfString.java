import java.util.*;

public class TestPriorityQueueOfString {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.offer("Naomi");
        queue.offer("Mike");
        queue.offer("Melanie");
        while (queue.size() > 0) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();

        queue = new PriorityQueue<>(3,(s1, s2) -> s1.length()-s2.length());
        queue.offer("Naomi");
        queue.offer("Mike");
        queue.offer("Melanie");
        while (queue.size() > 0) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}
