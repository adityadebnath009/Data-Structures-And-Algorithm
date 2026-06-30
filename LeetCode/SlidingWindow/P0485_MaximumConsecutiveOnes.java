/**
 * Platform: LeetCode
 * Problem ID: 485
 * Problem Name: Maximum Consecutive Ones
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/maximum-consecutive-ones/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0485_MaximumConsecutiveOnes {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0485_MaximumConsecutiveOnes...");
    }

    // TODO: Write solution method here
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int i = 0;
            int n = nums.length;
            int res = 0;
            int cnt = 0;
            while(i < n)
            {
                if(nums[i]==1)
                {
                    cnt++;
                }
                else
                {
                    res = Math.max(res, cnt);
                    cnt = 0;

                }
                i++;
            }
            res = Math.max(res, cnt);

            return res;

        }
    }
}
