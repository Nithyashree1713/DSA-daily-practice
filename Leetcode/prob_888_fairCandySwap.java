import java.util.*;

class prob_888_fairCadySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int a : aliceSizes) sumA += a;
        for (int b : bobSizes) sumB += b;

        int diff = (sumB - sumA) / 2;

        Set<Integer> bobSet = new HashSet<>();
        for (int b : bobSizes) bobSet.add(b);

        for (int a : aliceSizes) {
            int b = a + diff;
            if (bobSet.contains(b)) {
                return new int[]{a, b};
            }
        }
        return new int[]{};
    }

    // Main method for local testing
    public static void main(String[] args) {
        prob_888_fairCadySwap sol = new prob_888_fairCadySwap();

        int[] aliceSizes = {1, 1};
        int[] bobSizes = {2, 2};

        int[] result = sol.fairCandySwap(aliceSizes, bobSizes);

        System.out.println("Swap values: " + Arrays.toString(result));
        // Expected output: [1, 2]
    }
}
