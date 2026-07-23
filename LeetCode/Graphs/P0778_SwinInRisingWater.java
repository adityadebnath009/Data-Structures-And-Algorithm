/**
 * Platform: LeetCode
 * Problem ID: 778
 * Problem Name: Swin in Rising Water
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/swin-in-rising-water/
 * 
 * Complexity:
 * - Time Complexity: O(N*N*logN)
 * - Space Complexity: O(N*N)
 * 
 * Approach:
 * // TODO: Describe your approach here
 *
 * We use a modified Dijkstra’s algorithm where `dist[i][j]` represents the minimum water level required to reach cell `(i, j)`.
 * The cost of a path is not the sum of elevations, but the maximum elevation encountered along that path.
 * Therefore, while moving to a neighboring cell, the new path cost is `max(currentCost, grid[newX][newY])`.
 * We use a min heap to always process the path with the smallest required water level first.
 * If we find a path to a neighboring cell with a lower required water level than its current value,
 * we update it and add it to the heap. Once the destination is removed from the min heap, its cost is the minimum time required to reach it.
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
//Approach ---> Binary Search + BFS/DFS
//For N*N grid
// TC : O(N*N*LogT)
//SC : O(N*N)
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
        int low = grid[0][0];
        int high = 50*50 + 1;
        int ans = Integer.MAX_VALUE;



        while(low <= high)
        {
            int mid = low + (high - low)/2;

            if(check(grid, mid))
            {
                ans = Math.min(ans, mid);
                high = mid - 1;

            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;

    }

    boolean check(int grid[][], int t)
    {

        if(grid[0][0]>t)
        {
            return false;
        }

        int n = grid.length;
        Queue<Pair> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];
        visited[0][0] = true;
        q.add(new Pair(0, 0, grid[0][0]));


        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int currX = p.x;
            int currY = p.y;
            int currCost = p.w;

            if(currX == n-1 && currY==n-1)
            {
                return true;
            }
            for(int d[]:dir)
            {
                int newX = currX + d[0];
                int newY = currY + d[1];

                if(newX<0 || newY<0 || newX>=n || newY>=n || visited[newX][newY]==true)
                {
                    continue;
                }

                if(grid[newX][newY] > t)
                {
                    continue;
                }

                q.add(new Pair(newX, newY, grid[newX][newY]));
                visited[newX][newY] = true;

            }



        }
        return false;
    }


}
