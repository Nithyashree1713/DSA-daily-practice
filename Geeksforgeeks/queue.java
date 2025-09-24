import java.util.*;

// SpecialQueue Implementation
class queue {
    Queue<Integer> q;
    Deque<Integer> minDeque;
    Deque<Integer> maxDeque;

    public queue() {
        q = new LinkedList<>();
        minDeque = new LinkedList<>();
        maxDeque = new LinkedList<>();
    }

    public void enqueue(int x) {
        q.offer(x);

        while (!minDeque.isEmpty() && minDeque.peekLast() > x) {
            minDeque.pollLast();
        }
        minDeque.offerLast(x);

        while (!maxDeque.isEmpty() && maxDeque.peekLast() < x) {
            maxDeque.pollLast();
        }
        maxDeque.offerLast(x);
    }

    public void dequeue() {
        if (q.isEmpty()) return;

        int front = q.poll();

        if (!minDeque.isEmpty() && minDeque.peekFirst() == front) {
            minDeque.pollFirst();
        }

        if (!maxDeque.isEmpty() && maxDeque.peekFirst() == front) {
            maxDeque.pollFirst();
        }
    }

    public int getFront() {
        if (q.isEmpty()) return -1;
        return q.peek();
    }

    public int getMin() {
        if (minDeque.isEmpty()) return -1;
        return minDeque.peekFirst();
    }

    public int getMax() {
        if (maxDeque.isEmpty()) return -1;
        return maxDeque.peekFirst();
    }

    public static void main(String[] args) {
        queue sq = new queue();
        ArrayList<Integer> result = new ArrayList<>();

        // Example test case 1:
        // Queries: [[1, 4], [1, 2], [3], [4], [2], [5]]
        sq.enqueue(4);        // [4]
        sq.enqueue(2);        // [4,2]
        result.add(sq.getFront()); // -> 4
        result.add(sq.getMin());   // -> 2
        sq.dequeue();         // remove 4, queue = [2]
        result.add(sq.getMax());   // -> 2

        // Print results
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        // Example test case 2:
        // Queries: [[1, 3], [4], [1, 5], [5]]
        sq = new queue();
        result.clear();

        sq.enqueue(3);        // [3]
        result.add(sq.getMin());   // -> 3
        sq.enqueue(5);        // [3,5]
        result.add(sq.getMax());   // -> 5

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
