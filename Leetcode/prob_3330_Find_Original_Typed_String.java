public class prob_3330_Find_Original_Typed_String {
    static class Solution {
        public int possibleStringCount(String word) {
            int n = word.length();
            int count = n;
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) != word.charAt(i - 1)) {
                    count--;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example test cases
        String word1 = "aabb";
        String word2 = "abc";
        String word3 = "aaaa";

        System.out.println("Input: " + word1 + " → Output: " + sol.possibleStringCount(word1));
        System.out.println("Input: " + word2 + " → Output: " + sol.possibleStringCount(word2));
        System.out.println("Input: " + word3 + " → Output: " + sol.possibleStringCount(word3));
    }
}
