/**
 * Platform: LeetCode
 * Problem ID: 209
 * Problem Name: Minimum Size Subarray Sum
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0209_MinimumSizeSubarraySum...");
    }

    // TODO: Write solution method here
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int minSize = Integer.MAX_VALUE;
        int sum = 0;

        for(int j = 0;j < nums.length;j++)
        {
            sum += nums[j];
            while(sum >= target)
            {
                minSize = Math.min(minSize, j-i+1);
                sum -= nums[i];
                i++;
            }



        }
        return (minSize == Integer.MAX_VALUE)?0:minSize;

    }
}