/**
 * Platform: LeetCode
 * Problem ID: 778
 * Problem Name: Swin in Rising Water
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/swin-in-rising-water/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0778_SwinInRisingWater {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0778_SwinInRisingWater...");
    }

    // TODO: Write solution method here
}
class Solution {
    private final int dir[][] = {{-1,0}, {0,-1},{1, 0},{0, 1}};
    class Pair
    {
        int x;
        int y;
        int w;
        Pair(int x, int y, int w)
        {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    public int swimInWater(int[][] grid) {

        int n = grid.length;

        int maxElev = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < n;j++)
            {
                maxElev = Math.max(maxElev, grid[i][j]);
            }
        }

        if(maxElev==grid[0][0])
        {
            return grid[0][0];
        }

        int low = grid[0][0];
        int high = maxElev + 1;


        int ans = Integer.MAX_VALUE;
        ans = check(grid);
        return ans;


    }
    int check(int grid[][])
    {

        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.w - b.w);
        int dist[][] = new int[n][n];
        for(int d[]:dist)
        {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];

        pq.add(new Pair(0,0, dist[0][0]));


        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int currX = p.x;
            int currY = p.y;
            int currCost = p.w;

            if(currX==n-1 && currY==n-1)
            {
                return currCost;
            }

            if(currCost > dist[currX][currY])
                continue;

            for(int d[]: dir)
            {
                int newX = d[0] + currX;
                int newY = d[1] + currY;
                if(newX<0 || newY<0 || newX>=n || newY>=n)
                    continue;

                if(grid[newX][newY] == -1)
                {
                    continue;
                }

                int newCost = Math.max(currCost, grid[newX][newY]);

                if (newCost < dist[newX][newY]) {
                    dist[newX][newY] = newCost;
                    pq.add(new Pair(newX, newY, newCost));
                }

            }


        }
        return -1;


    }
}