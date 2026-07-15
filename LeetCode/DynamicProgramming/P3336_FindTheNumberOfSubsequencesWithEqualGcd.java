package LeetCode.DynamicProgramming;

/**
 * Platform: LeetCode
 * Problem ID: 3336
 * Problem Name: Find the Number of Subsequences With Equal GCD
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P3336_FindTheNumberOfSubsequencesWithEqualGcd {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P3336_FindTheNumberOfSubsequencesWithEqualGcd...");
    }

    // TODO: Write solution method here
}


class Solution {
    int dp[][][];
    private final int MOD = 1000000007;
    public int subsequencePairCount(int[] nums) {
        dp = new int[nums.length][201][201];
        for(int d[][]:dp)
        {
            for(int row[]:d)
            {
                Arrays.fill(row,-1);
            }

        }

        return solve(nums, 0, 0, 0);

    }
    int solve(int nums[], int g1, int g2, int i)
    {
        if(i==nums.length)
        {
            if(g1==0 || g2==0)
            {
                return 0;
            }
            return g1==g2?1:0;
        }
        if(dp[i][g1][g2]!=-1)
        {
            return dp[i][g1][g2];
        }
        long skip = solve(nums, g1, g2, i + 1);
        long take1 = solve(nums, gcd(g1, nums[i]), g2, i+1);
        long take2 = solve(nums, g1 , gcd(g2, nums[i]), i+1);



        return dp[i][g1][g2] = (int)((skip + take1 + take2)%MOD);

    }

    int gcd(int a, int b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b, a%b);
    }
}
