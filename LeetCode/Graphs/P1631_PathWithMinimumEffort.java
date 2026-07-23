/**
 * Platform: LeetCode
 * Problem ID: 1631
 * Problem Name: Path With Minimum Effort
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/path-with-minimum-effort/
 * 
 * Complexity:
 *
 * - Space Complexity: O(m * n)
 * -DFS: O(m × n)
 * -Binary Search: O(log(maxDifference))
 * -Final Time Complexity: O(m * n * log(maxDifference))
 * 
 * Approach:
 * // TODO: Describe your approach here
 * Here, the effort is the absolute difference, the cost, between any two cell heights.
 * We apply binary search to evaluate each possible cost. Suppose edge cost equals k.
 * We check whether, with at most k cost, we can reach our destination.
 * If not, we increase the h cost; otherwise, we store it and try for shorter edge cost.
 *
 * Binary Search + DFS/BFS
 *
 * Guess an effort k.
 * Check if a path exists using only edges with difference ≤ k.
 * Feasibility is monotonic:
 * If k works, any larger effort also works.
 * If k doesn't work, any smaller effort won't work.
 * Time: O(m × n × log(MaxHeightDifference))
 */

public class P1631_PathWithMinimumEffort {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1631_PathWithMinimumEffort...");
    }

    // TODO: Write solution method here
    private int dir[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    class Pair{
        int x;
        int y;
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public boolean canReach(int heights[][], boolean visited[][], int cost, int x, int y, int m, int n)
    {
        if(x==m-1 && y==n-1)
        {
            return true;
        }
        visited[x][y] = true;

        for(int d[]:dir)
        {
            int u = x + d[0];
            int v = y + d[1];

            if(u>=0 && v>=0 && u<m && v<n && visited[u][v]==false)
            {
                int absDiff = Math.abs(heights[x][y] - heights[u][v]);
                if(absDiff<=cost && canReach(heights, visited,  cost, u, v, m, n))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;


        int left = 0;
        int right = 1000000;
        int res = -1;

        while(left<=right)
        {
            boolean visited[][] = new boolean[m][n];

            int mid = left + (right - left)/2;

            if(canReach(heights, visited, mid, 0, 0, m, n))
            {
                res = mid;
                right = mid - 1;
            }
            else
            {
                left = mid  + 1;
            }
        }


        return res;


    }
}
