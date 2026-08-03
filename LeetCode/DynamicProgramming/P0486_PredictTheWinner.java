package LeetCode.DynamicProgramming;

/**
 * Platform: LeetCode
 * Problem ID: 486
 * Problem Name: Predict The Winner
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/predict-the-winner/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0486_PredictTheWinner {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0486_PredictTheWinner...");
    }

    // TODO: Write solution method here
}
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n][n];
        for(int row[]:dp)
        {
            Arrays.fill(row, -1);
        }

        int sum = 0;
        for(int num:nums)
        {
            sum += num;
        }
        int p1 = solve(nums,dp,  0, nums.length - 1);


        return p1>=0;
    }
    int solve(int nums[], int dp[][], int i, int j)
    {
        if(i<0 || i >= nums.length)
            return 0;
        if(j < 0 || j >= nums.length)
            return 0;
        if(i>j)
        {
            return 0;
        }

        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }


        int take_i = nums[i] - solve(nums, dp, i+1, j);
        int take_j = nums[j] - solve(nums, dp, i, j-1);

        return dp[i][j] = Math.max(take_i, take_j);


    }
}