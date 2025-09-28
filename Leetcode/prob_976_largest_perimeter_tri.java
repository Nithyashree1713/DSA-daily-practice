import java.util.*;

class prob_976_largest_perimeter_tri {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    // main method to run in VS Code
    public static void main(String[] args) {
        prob_976_largest_perimeter_tri sol = new prob_976_largest_perimeter_tri();
        
        int[] nums1 = {2, 1, 2};
        int[] nums2 = {1, 2, 1, 10};
        
        System.out.println("Largest Perimeter (nums1): " + sol.largestPerimeter(nums1));
        System.out.println("Largest Perimeter (nums2): " + sol.largestPerimeter(nums2));
    }
}
