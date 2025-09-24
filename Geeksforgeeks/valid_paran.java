
public class valid_paran {
    public int minParentheses(String s) {
        int balance = 0;     // counts unmatched '('
        int insertions = 0;  // counts needed insertions

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else { // ch == ')'
                if (balance > 0) {
                    balance--;  // match with previous '('
                } else {
                    insertions++;  // need an extra '('
                }
            }
        }

        // Add remaining unmatched '('
        return insertions + balance;
    }

    public static void main(String[] args) {
        valid_paran sol = new valid_paran();

        // Example test cases
        String s1 = "(()(";
        String s2 = ")))";
        String s3 = ")()()";

        System.out.println("Input: " + s1 + " → Output: " + sol.minParentheses(s1));
        System.out.println("Input: " + s2 + " → Output: " + sol.minParentheses(s2));
        System.out.println("Input: " + s3 + " → Output: " + sol.minParentheses(s3));
    }
}
