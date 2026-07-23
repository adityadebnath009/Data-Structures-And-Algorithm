/**
 * Platform: LeetCode
 * Problem ID: 1293
 * Problem Name: Shortest Path in a Grid with Obstacles Elimination
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * //
 * Summary
 * Goal: Find the minimum number of steps from the top-left to the bottom-right.
 * Why BFS?
 * Every move costs exactly 1 step.
 * BFS explores the grid level by level, so the first time we reach the destination, it is guaranteed to be the shortest path.
 * Why isn't visited[x][y] enough?
 * Reaching the same cell with different numbers of obstacle eliminations remaining can lead to different future possibilities.
 *         Therefore, the state is not just (x, y) but (x, y, remainingK).
 * What makes one state better than another?
 * If two paths reach the same cell, the one with more eliminations remaining is always better because it has greater flexibility to remove future obstacles.
 * Optimization (Pruning):
 *
 * Instead of storing every (x, y, remainingK) state, we keep:
 *
 * bestRem[x][y]
 *
 * which stores the maximum remaining eliminations seen when reaching that cell.
 *
 * If we reach the same cell again with fewer or equal eliminations remaining, we discard that path because it can never outperform the previously discovered one.
 * Key Insight:
 * BFS guarantees the minimum number of steps.
 * bestRem ensures that among all ways to reach the same cell, we continue exploring only the most promising one (the one with the most eliminations left).
 * One-line takeaway
 *
 * Use BFS because we want the minimum number of steps, and augment the BFS state with remainingK because future decisions depend on how many obstacle eliminations are left.
 *  Among multiple ways to reach the same cell, keep only the one with the maximum remaining eliminations.
 */

public class P1293_ShortestPathInAGridWithObstaclesElimination {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1293_ShortestPathInAGridWithObstaclesElimination...");
    }

    // TODO: Write solution method here

}
class Solution {
    private final int dir[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    class Pair{
        int x;
        int y;
        int remK;
        Pair(int x, int y, int remK)
        {
            this.x = x;
            this.y = y;
            this.remK = remK;
        }
    }
    public int shortestPath(int[][] grid, int k) {

        Queue<Pair> pq = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        int bestRem[][] = new int[m][n];


        for(int row[]:bestRem)
        {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        bestRem[0][0] = k -  grid[0][0];
        pq.add(new Pair(0 , 0, bestRem[0][0]));
        int steps = 0;

        while(!pq.isEmpty())
        {
            int size = pq.size();
            while(size-- > 0)
            {
                Pair p =  pq.poll();
                int x = p.x;
                int y = p.y;
                int remK = p.remK;
                if(x==m-1 && y==n-1)
                {
                    return steps;
                }

                for(int d[]:dir)
                {
                    int newX = x + d[0];
                    int newY = y + d[1];

                    if(newX>=0 && newY>=0 && newX<m && newY<n)
                    {
                        int newRem = remK - grid[newX][newY];
                        if(newRem >=0 && bestRem[newX][newY] < newRem)
                        {
                            bestRem[newX][newY] = newRem;
                            pq.add(new Pair(newX, newY, bestRem[newX][newY]));

                        }
                    }
                }



            }
            steps++;
        }



        return -1;

    }
}

//Approach2:  Dijkstra


