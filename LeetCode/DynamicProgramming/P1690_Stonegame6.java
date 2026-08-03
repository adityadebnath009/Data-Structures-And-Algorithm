package LeetCode.DynamicProgramming;

/**
 * Platform: LeetCode
 * Problem ID: 1690
 * Problem Name: StoneGame6
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/stonegame6/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P1690_Stonegame6 {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1690_Stonegame6...");
    }

    // TODO: Write solution method here
}
class Solution {
    public int stoneGameVII(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        int dp[][] = new int[n][n];
        for(int rows[]:dp)
        {
            Arrays.fill(rows, -1);
        }
        prefix[0] = nums[0];

        for(int i = 1;i < n;i++)
        {
            prefix[i] = prefix[i-1] + nums[i];
        }

        return solve(nums, dp, prefix, 0, n-1);

    }
    int solve(int stones[], int dp[][], int prefix[], int i, int j)
    {
        if(i<0 || i >= stones.length)
            return 0;
        if(j < 0 || j >= stones.length)
            return 0;
        if(i>j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }

        int take_i = (prefix[j] - prefix[i])  - solve(stones, dp, prefix, i+1, j);
        int take_j = ((j>0?prefix[j-1]:0) - (i>0?prefix[i-1]:0)) - solve(stones, dp, prefix, i, j-1);

        return dp[i][j] = Math.max(take_i, take_j);
    }
}