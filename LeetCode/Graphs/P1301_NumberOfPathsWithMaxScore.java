/**
 * Platform: LeetCode
 * Problem ID: 1301
 * Problem Name: Number of Paths with Max Score
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/number-of-paths-with-max-score/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P1301_NumberOfPathsWithMaxScore {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1301_NumberOfPathsWithMaxScore...");
    }

    // TODO: Write solution method here
}


//Approach 1: Top Down Dp
/*
* For every cell, store both the maximum score achievable to reach that cell and
*  the number of paths that achieve exactly that maximum score.
* Among all predecessor cells, take only those having the maximum score and sum their path counts.
* dp[i][j][0] = maximum score to reach (i, j)
* dp[i][j][1] = number of paths achieving that maximum score
* */
class Solution {
    private final int dir[][] = {{0,-1},{-1,0},{-1,-1}};
    private final int MOD = 1000000007;
    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();

        char b[][] = new char[n][n];

        int dp[][][] = new int[n][n][2];

        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < n;j++)
            {
                b[i][j] = board.get(i).charAt(j);
                dp[i][j][0] = -1; //maxSum
                dp[i][j][1] = 0;  // paths required to reach that maxSum;
            }
        }
        int ans[] = solve(dp, b, n-1, n-1, n);

        return ans[0]==-1?new int[]{0,0}:ans;

    }
    int[] solve(int dp[][][],char [][]board, int i, int j, int n)
    {
        if(i==0 && j==0)
        {
            return new int[]{0, 1};
        }
        if(i<0 || j<0)
        {
            return new int[]{-1, 0};
        }
        if(board[i][j]=='X')
        {
            return new int[]{-1, 0};
        }
        if(dp[i][j][0]!=-1)
        {
            return dp[i][j];
        }
        int val = (board[i][j] == 'S') ? 0 : board[i][j] - '0';
        int up_left[] = solve(dp, board, i -1,j-1, n);
        int left[] = solve(dp, board, i,j-1, n);
        int up[] = solve(dp, board, i-1,j, n);

        int maxSum = Math.max(up_left[0], Math.max(up[0], left[0]));

        if(maxSum==-1)
        {
            dp[i][j][0] = -1;
            dp[i][j][1] = 0;
            return dp[i][j];
        }

        int ways = 0;
        if(up[0] == maxSum){
            ways = (ways + up[1])%MOD;
        }
        if(left[0] == maxSum){
            ways = (ways + left[1])%MOD;
        }
        if(up_left[0] == maxSum){
            ways = (ways + up_left[1])%MOD;
        }


        dp[i][j][0] = maxSum + val;
        dp[i][j][1] = ways;
        return dp[i][j];
    }

}


//Approach 2: Bottom-Up DP
class Solution {

    private final int MOD = 1000000007;
    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();

        char b[][] = new char[n][n];

        int dp[][][] = new int[n][n][2];

        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < n;j++)
            {
                b[i][j] = board.get(i).charAt(j);
                dp[i][j][0] = -1; //maxSum
                dp[i][j][1] = 0;  // paths required to reach that maxSum;
            }
        }

        dp[0][0][0] = 0;
        dp[0][0][1] = 1;

        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < n;j++)
            {
                if(i==0 && j==0)
                {
                    continue;
                }
                if(b[i][j]=='X')
                {
                    continue;
                }

                int maxSum = -1;
                int ways = 0;

                if(j>0)
                {
                    maxSum  = Math.max(maxSum,dp[i][j-1][0]);
                }
                if(i>0)
                {
                    maxSum  = Math.max(maxSum,dp[i-1][j][0]);
                }
                if(i>0 && j>0)
                {
                    maxSum  = Math.max(maxSum,dp[i-1][j-1][0]);
                }

                if(maxSum==-1)
                {
                    continue;
                }

                int val = ( b[i][j]=='S' )? 0: b[i][j] - '0';


                if(j > 0 && dp[i][j-1][0] == maxSum){
                    ways = (ways + dp[i][j-1][1])%MOD;
                }
                if(i>0 && dp[i-1][j][0] == maxSum){
                    ways = (ways + dp[i-1][j][1])%MOD;
                }
                if(i>0 && j>0 && dp[i-1][j-1][0] == maxSum){
                    ways = (ways + dp[i-1][j-1][1])%MOD;
                }
                dp[i][j][0] = maxSum + val;
                dp[i][j][1] = ways;

            }
        }

        return dp[n-1][n-1][0]==-1?new int[]{0,0} : dp[n-1][n-1];
    }
}
