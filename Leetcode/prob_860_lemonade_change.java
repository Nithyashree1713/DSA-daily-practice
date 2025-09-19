class prob_860_lemonade_change {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else { // bill == 20
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        prob_860_lemonade_change sol = new prob_860_lemonade_change();

        // Example array (hardcoded)
        int[] bills = {5, 5, 5, 10, 20};

        boolean result = sol.lemonadeChange(bills);
        System.out.println("Result: " + result);
    }
}
