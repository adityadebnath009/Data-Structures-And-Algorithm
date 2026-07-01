/**
 * Platform: LeetCode
 * Problem ID: 2812
 * Problem Name: Find the Safest Path in a Grid
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/find-the-safest-path-in-a-grid/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P2812_FindTheSafestPathInAGrid {
    class Pair{
        int x;
        int y;
        int score;
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
        Pair(int score, int x, int y)
        {
            this.score = score;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P2812_FindTheSafestPathInAGrid...");
    }

    // TODO: Write solution method here
    void multiBfs(int mat[][], int dist[][], int n)
    {

        Queue<Pair> q = new LinkedList<>();
        //find the thieve cells
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < n;j++)
            {
                if(mat[i][j]==1)
                    q.add(new Pair(i, j));
            }
        }

        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int d[]:dir)
            {
                int u = d[0] + x;
                int v = d[1] + y;

                if(u>=0 && v>=0 && u<n && v<n && dist[u][v]>dist[x][y] + 1)
                {
                    dist[u][v] = dist[x][y] + 1;
                    q.add(new Pair(u,v));
                }
            }
        }

    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        int mat[][] = new int[n][n];
        int dist[][] = new int[n][n];

        for(int row[]:dist)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < n;j++)
            {
                if(grid.get(i).get(j)==1)
                {
                    dist[i][j] = 0;
                }
                mat[i][j] = grid.get(i).get(j);
            }
        }

        multiBfs(mat, dist, n);

        boolean visited[][] = new boolean[n][n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.score - a.score);
        pq.add(new Pair(dist[0][0], 0, 0));


        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int currSafe = p.score;
            int x = p.x;
            int y = p.y;

            if(x==n-1 && y==n-1)
            {
                return currSafe;
            }

            if(visited[x][y])
                continue;

            visited[x][y] = true;

            for(int d[]:dir)
            {
                int u = d[0] + x;
                int v = d[1] + y;


                if(u>=0 && v>=0 && u<n && v<n && visited[u][v]==false)
                {
                    int neighSafe = dist[u][v];
                    int newSafeness = Math.min(currSafe, neighSafe);
                    pq.add(new Pair(newSafeness, u, v));
                }


            }
        }


        return -1;

    }

}
