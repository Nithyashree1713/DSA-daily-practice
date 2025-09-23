package Geeksforgeeks;
import java.util.*;

// Solution class
class queue_traversal{
    // Recursive approach to reverse a queue
    public void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int front = q.poll();
        reverseQueue(q);
        q.offer(front);
    }
}

// Main class to test in VS Code
public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Sample input
        q.offer(5);
        q.offer(10);
        q.offer(15);
        q.offer(20);
        q.offer(25);

        System.out.println("Original Queue: " + q);

        queue_traversal sol = new queue_traversal();
        sol.reverseQueue(q);

        System.out.println("Reversed Queue: " + q);
    }
}
