package LeetCode.DynamicProgramming;

/**
 * Platform: LeetCode
 * Problem ID: 1547
 * Problem Name: Min Cost to Cut Stick
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/min-cost-to-cut-stick/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P1547_MinCostToCutStick {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1547_MinCostToCutStick...");
    }

    // TODO: Write solution method here
}
class Solution {
    public int minCost(int n, int[] cuts) {

        int dp[][] = new int[102+1][102+1];

        for(int rows[]:dp)
        {
            Arrays.fill(rows, -1);
        }


        int newCuts[] = new int[cuts.length+2];
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        int k = 1;
        for(int i = 0;i < cuts.length;i++)
        {
            newCuts[k++] = cuts[i];
        }
        Arrays.sort(newCuts);

        return solve(newCuts, dp, 0, newCuts.length-1);

    }
    int solve(int cuts[], int dp[][], int l,int r)
    {
        if(1 == r - l)
        {
            return 0;
        }
        if(dp[l][r] != -1)
        {
            return dp[l][r];
        }
        int result = Integer.MAX_VALUE;

        for(int i = l+1;i < r;i++)
        {
            int currCost = cuts[r] - cuts[l];
            int total = currCost + solve(cuts, dp,  l,i) + solve(cuts, dp, i, r);
            result = Math.min(result, total);
        }

        return dp[l][r]=result;
    }
}