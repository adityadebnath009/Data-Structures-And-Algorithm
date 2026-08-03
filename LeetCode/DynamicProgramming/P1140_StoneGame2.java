package LeetCode.DynamicProgramming;

/**
 * Platform: LeetCode
 * Problem ID: 1140
 * Problem Name: Stone Game 2
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/stone-game-2/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P1140_StoneGame2 {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1140_StoneGame2...");
    }

    // TODO: Write solution method here
}
class Solution {
    int dp[][];
    public int stoneGameII(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];

        dp = new int[n][n+1];
        for(int rows[]:dp)
        {
            Arrays.fill(rows, -1);
        }
        prefix[0] = nums[0];

        for(int i = 1;i < n;i++)
        {
            prefix[i] = prefix[i-1] + nums[i];
        }

        return solve(nums, prefix, 0, 1);


    }
    int solve(int piles[], int prefix[],int i, int M)
    {
        int n = prefix.length;
        if(i>=n)
        {
            return 0;
        }
        if(dp[i][M]!=-1)
        {
            return dp[i][M];
        }
        if(M*2>=n - i)
        {
            return prefix[n-1] - (i>0?prefix[i-1]:0);
        }
        int remaining = prefix[n-1] - (i>0?prefix[i-1]:0);
        int ans = 0;
        for(int x = 1; x <= Math.min(n-i, 2*M);x++)
        {
            ans = Math.max(ans, remaining - solve(piles, prefix, i + x, Math.max(x, M)));
        }
        return dp[i][M] = ans;
    }
}