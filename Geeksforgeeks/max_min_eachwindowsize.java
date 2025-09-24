
import java.util.*;

class max_min_eachwindowsize {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] res = new int[n + 1]; // 1-based indexing
        Arrays.fill(res, Integer.MIN_VALUE);

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        // Previous smaller element
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            left[i] = (st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }

        st.clear();

        // Next smaller element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            right[i] = (st.isEmpty() ? n : st.peek());
            st.push(i);
        }

        // Fill results for window length
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            res[len] = Math.max(res[len], arr[i]);
        }

        // Fill remaining values
        for (int i = n - 1; i >= 1; i--) {
            res[i] = Math.max(res[i], res[i + 1]);
        }

        // Convert to ArrayList
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(res[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        max_min_eachwindowsize sol = new max_min_eachwindowsize();

        int[] arr1 = {10, 20, 30, 50, 10, 70, 30};
        System.out.println(sol.maxOfMins(arr1));
        // Expected: [70, 30, 20, 10, 10, 10, 10]

        int[] arr2 = {10, 20, 30};
        System.out.println(sol.maxOfMins(arr2));
        // Expected: [30, 20, 10]
    }
}
