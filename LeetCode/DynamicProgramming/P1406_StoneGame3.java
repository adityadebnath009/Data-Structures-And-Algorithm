package LeetCode.DynamicProgramming;

/**
 * Platform: LeetCode
 * Problem ID: 1406
 * Problem Name: Stone Game 3
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/stone-game-3/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P1406_StoneGame3 {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1406_StoneGame3...");
    }

    // TODO: Write solution method here
}
class Solution {
    public String stoneGameIII(int[] nums) {
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, -1);

        int ans =  solve(nums, dp, 0);
        if(ans>0)
        {
            return "Alice";
        }
        else if(ans < 0)
        {
            return "Bob";
        }
        return "Tie";
    }
    int solve(int nums[], int dp[], int i)
    {
        if(i>=nums.length)
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }


        int take_1 = nums[i] - solve(nums, dp, i+1);
        int take_2 = Integer.MIN_VALUE;
        if(i+1<nums.length)
        {
            take_2 = (nums[i] + nums[i+1])  - solve(nums, dp, i+2);
        }
        int take_3 = Integer.MIN_VALUE;
        if(i+2<nums.length)
        {
            take_3 = (nums[i] + nums[i+1] + nums[i+2]) - solve(nums, dp, i+3);
        }

        return dp[i] = Math.max(take_1, Math.max(take_2, take_3));
    }



}