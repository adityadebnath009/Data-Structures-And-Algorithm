/**
 * Platform: LeetCode
 * Problem ID: 2054
 * Problem Name: Two Best Non-Overlapping Events
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/two-best-non-overlapping-events/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P2054_TwoBestNonOverlappingEvents {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P2054_TwoBestNonOverlappingEvents...");
    }

    // TODO: Write solution method here

}
class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));
        int dp[][] = new int[n][3];
        for(int row[]: dp)
        {
            Arrays.fill(row, -1);
        }


        return solve(events, dp, 0, 0, n);

    }
    int solve(int[][] events, int dp[][], int count, int i, int n)
    {
        if(count==2 || i>=n)
        {
            return 0;
        }

        if(dp[i][count]!=-1)
        {
            return dp[i][count];
        }

        int skip = solve(events, dp, count, i + 1, n);


        //find the valid index to attend the second event
        int low = i + 1;
        int high = n - 1;
        int indx = Integer.MAX_VALUE;
        while(low <= high)
        {
            int mid = low + (high - low)/2;

            if(events[i][1]<events[mid][0])
            {
                indx = Math.min(indx, mid);
                high = mid - 1;

            }
            else
            {
                low = mid + 1;
            }
        }
        int attend = events[i][2] + solve(events, dp, count + 1, indx, n);
        return dp[i][count] = Math.max(skip, attend);

    }
}
