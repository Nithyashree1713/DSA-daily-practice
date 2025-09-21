package Geeksforgeeks;

import java.util.*;

class max_rectangle {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        // Check feasibility
        if (total - target < 0 || (total - target) % 2 != 0) {
            return 0;
        }
        int newTarget = (total - target) / 2;

        int[][] dp = new int[n][newTarget + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return find(nums, newTarget, n - 1, dp);
    }

    private int find(int[] nums, int target, int idx, int[][] dp) {
        if (idx == 0) {
            if (nums[0] == 0 && target == 0) return 2; // two choices (+0, -0)
            if (nums[0] == target || target == 0) return 1;
            return 0;
        }
        if (dp[idx][target] != -1) return dp[idx][target];

        int noPick = find(nums, target, idx - 1, dp);
        int pick = 0;
        if (nums[idx] <= target) {
            pick = find(nums, target - nums[idx], idx - 1, dp);
        }
        return dp[idx][target] = pick + noPick;
    }

    public static void main(String[] args) {
        max_rectangle sol = new max_rectangle();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(sol.findTargetSumWays(nums, target)); 
        // Expected Output = 5
    }
}

