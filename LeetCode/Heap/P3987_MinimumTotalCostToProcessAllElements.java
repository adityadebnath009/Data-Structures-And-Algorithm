/**
 * Platform: LeetCode
 * Problem ID: 3987
 * Problem Name: Minimum Total Cost to Process All Elements
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/minimum-total-cost-to-process-all-elements/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P3987_MinimumTotalCostToProcessAllElements {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P3987_MinimumTotalCostToProcessAllElements...");
    }

    // TODO: Write solution method here
}
class Solution {
    private final long MOD = 1000000007L;
    private static final long INV2 = 500000004L;

    public int minimumCost(int[] nums, int k) {



        long initialK = k;
        long res = k;
        long totalCost = 0;
        long currCost  = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=res)
            {
                res = res - (long)nums[i];
            }
            else
            {
                long needed = nums[i] - res;

                long op = (needed + initialK - 1L)/initialK;

                res = res + op*initialK;

                long a = op % MOD;
                long b = (2 * (currCost % MOD) + (op % MOD) + 1) % MOD;

                long sum = (a * b) % MOD;
                sum = (sum * INV2) % MOD;

                totalCost = (totalCost + sum) % MOD;

                currCost += op;

                res = res - (long)nums[i];
            }
        }

        return (int)totalCost;
    }
}