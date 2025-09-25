import java.util.*;

public class GenerateBinary {
    public static ArrayList<String> generateBinary(int n) {
        ArrayList<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.add("1");

        for (int i = 1; i <= n; i++) {
            String curr = q.poll();
            result.add(curr);
            q.add(curr + "0");
            q.add(curr + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<String> binaries = generateBinary(n);
        System.out.println("Binary numbers from 1 to " + n + ": " + binaries);
    }
}
