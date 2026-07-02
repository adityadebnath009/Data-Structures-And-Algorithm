/**
 * Platform: LeetCode
 * Problem ID: 3286
 * Problem Name: Find Safe Walk Through a Grid
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/find-safe-walk-through-a-grid/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P3286_FindSafeWalkThroughAGrid {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P3286_FindSafeWalkThroughAGrid...");
    }

    // TODO: Write solution method here
}
//Approach 1: 3D Dp Approach




class Solution {
    private final int dir[][] = {{1,0},{0,1},{0,-1},{-1,0}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int best[][] = new int[m][n];
        //To track the best health we have seen so far to reach cell(x, y)
        for(int row[]:best)
        {
            Arrays.fill(row, -1);
        }


        return solve(grid, best, m, n, 0, 0, health);


    }
    boolean solve(List<List<Integer>> grid, int best[][], int m, int n, int x, int y, int h)
    {
        // We are subtracting the health here because if health  = 1 and cost at (x,y)=1 then we need to deduct the cost so that we can stay at cell(x,y)

        h -= grid.get(x).get(y);//current health at these cell(x, y)

        //If at any cell (x,y) --->health < 1 return false
        if(h<1)
        {
            return false;
        }

        //Finally reached a cell with health > 1
        if(x==m-1 && y==n-1)
        {
            return true;
        }

        //It is better to reach a cell with more health.
        if(h <= best[x][y])
        {
            return false;
        }

        //found a better health to reach a cell
        best[x][y] = h;

        for(int d[]:dir)
        {
            int nx = x + d[0];
            int ny = y + d[1];

            if(nx>=0 && ny>=0 && nx<m && ny<n)
            {

                if(solve(grid,best,m,n,nx,ny,h))
                {

                    return true;
                }
            }
        }

        return false;
    }

}
//Approach 2: Dijkstra Approach

class Solution {
    private final int dir[][] = {{1,0},{0,1},{0,-1},{-1,0}};
    class Pair{
        int x;
        int y;
        int h;
        Pair(int x, int y, int h)
        {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.h - b.h);

        int m = grid.size();
        int n = grid.get(0).size();

        int distance[][] = new int[m][n];

        for(int row[]:distance)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        boolean visited[][] = new boolean[m][n];
        distance[0][0] = grid.get(0).get(0);
        pq.add(new Pair(0, 0,  distance[0][0]));


        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int x = p.x;
            int y = p.y;
            int h = p.h;

            if(visited[x][y])
            {
                continue;
            }
            visited[x][y] = true;

            for(int d[]:dir)
            {
                int u = x + d[0];
                int v = y + d[1];

                if(u>=0 && v>=0 && u<m && v<n && visited[u][v]==false)
                {
                    if(grid.get(u).get(v) + h < distance[u][v])
                    {
                        distance[u][v] = grid.get(u).get(v) + h ;
                        pq.add(new Pair(u ,v, distance[u][v]));
                    }
                }
            }

        }

        return distance[m-1][n-1]<health;


    }
}

//Approach 3: 0/1 BFS Approach

//------------------------------------------------------------------------------
//Approach 3: BFS

//Think of the deque as maintaining two distance levels:
//
//Front  --->     distance d
//                distance d
//                distance d
//                distance d+1
//                distance d+1  <--- Back
//Weight 0 → stays in the current level (addFirst).
//Weight 1 → moves to the next level (addLast).

//That's why 0-1 BFS can replace the priority queue with a deque while still processing nodes in nondecreasing order of distance.




class Solution {
    private final int dir[][] = {{1,0},{0,1},{0,-1},{-1,0}};
    class Pair{
        int x;
        int y;
        int h;
        Pair(int x, int y, int h)
        {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        Deque<Pair> dq = new ArrayDeque<>();

        dq.add(new Pair(0 ,0 , grid.get(0).get(0)));

        int dist[][] = new int[m][n];

        for(int row[]:dist)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = grid.get(0).get(0);

        while(!dq.isEmpty())
        {
            Pair p = dq.pollFirst();

            int x = p.x;
            int y = p.y;
            int h = p.h;

            if(h > dist[x][y])
            {
                continue;
            }


            for(int d[]:dir)
            {
                int u = x + d[0];
                int v = y + d[1];
                if(u>=0 && v>=0 && u<m && v<n)
                {
                    int weight = grid.get(u).get(v);
                    if(h + weight < dist[u][v])
                    {
                        dist[u][v] = h + weight;
                        if(weight == 0)
                            dq.addFirst(new Pair(u , v, dist[u][v]));
                        else
                            dq.addLast(new Pair(u , v, dist[u][v]));
                    }
                }

            }
        }

        return dist[m-1][n-1]<health;
    }
}
