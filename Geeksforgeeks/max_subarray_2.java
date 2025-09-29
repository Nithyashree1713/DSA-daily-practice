import java.util.*;

public class max_subarray_2 {
    static class Solution {
        public int maxSubarrSum(int[] arr, int a, int b) {
            int n = arr.length;
            long[] prefix = new long[n + 1];
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + arr[i];
            }

            Deque<Integer> dq = new ArrayDeque<>();
            long ans = Long.MIN_VALUE;

            for (int i = a; i <= n; i++) {
                // maintain deque for range [i-b, i-a]
                while (!dq.isEmpty() && dq.peekFirst() < i - b) {
                    dq.pollFirst();
                }
                // add candidate index for subarray ending at i
                dq.addLast(i - a);

                // check maximum sum for current i
                if (!dq.isEmpty()) {
                    ans = Math.max(ans, prefix[i] - prefix[dq.peekFirst()]);
                }

                // maintain increasing order of prefix in deque
                while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[i - a + 1]) {
                    dq.pollLast();
                }
            }
            return (int) ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);

        // Example input
        int[] arr = {4, 5, -1, -2, 6};
        int a = 2, b = 4;
        System.out.println(sol.maxSubarrSum(arr, a, b)); // Output: 9

        int[] arr2 = {-1, 3, -1, -2, 5, 3, -5, 2, 2};
        a = 3;
        b = 5;
        System.out.println(sol.maxSubarrSum(arr2, a, b)); // Output: 8

        sc.close();
    }
}
