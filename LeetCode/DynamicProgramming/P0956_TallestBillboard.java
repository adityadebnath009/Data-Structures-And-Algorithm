package LeetCode.DynamicProgramming;

/**
 * Platform: LeetCode
 * Problem ID: 956
 * Problem Name: Tallest Billboard
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/tallest-billboard/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO:
 * To do this without passing h, we can make our function solve(i, d) return the maximum height we can get,
 * rather than carrying it along as a parameter.
 *
 * Think of solve(i, d) as: "What is the maximum height of the taller tower we can build using the rods from index i onwards,
 * starting with a difference of d?"
 *
 * When we make a choice, we only care about how much the taller tower's height increases because of that choice.
 *
 * Here is how the three choices look when we return the height:
 *
 * Skip the rod: The taller tower doesn't grow. int skip = solve(i + 1, d);
 *
 * Add to the taller tower: The taller tower grows by L, and the new difference is d + L. int add_taller = L + solve(i + 1, d + L);
 *
 * Add to the shorter tower: The new difference becomes abs(d - L). But how much does the taller tower grow?
 *
 * If L > d, the shorter tower shoots past the taller one, so the taller tower's height increases by L - d.
 *
 * If L <= d, the taller tower's height doesn't change (increase is 0).
 *
 * So, the increase is max(0, L - d).
 *
 * int add_shorter = max(0, L - d) + solve(i + 1, abs(d - L));
 */

public class P0956_TallestBillboard {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0956_TallestBillboard...");
    }

    // TODO: Write solution method here
}

class Solution {
    public int tallestBillboard(int[] rods) {

        int dp[][] = new int[21][5001];

        for(int row[]:dp)
        {
            Arrays.fill(row, -1);
        }


        return solve(rods, dp, 0, 0);

    }
    int solve(int rods[], int dp[][], int i, int d)
    {

//         When we've looked at all the rods (i == rods.length),
//         we check if our towers are balanced (d == 0).
//         If they are, we return 0. If not, we return -infinity to mark it as an invalid way to build the towers
        if(i==rods.length)
        {
            if(d==0)
            {
                return 0;
            }
            else
            {
                return (int)(-1e9);
            }
        }

        if(dp[i][d]!=-1)
        {
            return dp[i][d];
        }

        int skip = solve(rods, dp, i+1, d);

        int L = rods[i];

        int take_larger = L + solve(rods, dp, i+1, d + L);

        int take_smaller = Math.max(0, L - d) + solve(rods, dp, i + 1, Math.abs(L - d));

        return dp[i][d] = Math.max(skip, Math.max(take_larger, take_smaller));

    }
}