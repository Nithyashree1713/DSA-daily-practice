public class prob_2220_bit_flips {
    public static int minBitFlips(int start, int goal) {
        int xor = start ^ goal;   // XOR shows differing bits
        int count = 0;
        while (xor > 0) {
            count += xor & 1;     // check last bit
            xor >>= 1;            // shift right
        }
        return count;
    }

    public static void main(String[] args) {
        int start = 10, goal = 7;
        int result = minBitFlips(start, goal);
        System.out.println("Minimum bit flips from " + start + " to " + goal + ": " + result);
    }
}
