/**
 * Platform: GeeksForGeeks
 * Problem ID: 
 * Problem Name: Detect Cycle Using DSU
 * Difficulty: Medium
 * 
 * Link: Link to problem
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P__DetectCycleUsingDsu {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P__DetectCycleUsingDsu...");
    }

    // TODO: Write solution method here
}
class Solution {
    int parent[];
    int rank[];
    public boolean detectCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        // code here
        parent = new int[n];
        rank = new int[n];
        for(int i = 0;i < n;i++)
        {
            parent[i] = i;
        }

        for(int u = 0;u < n;u++)
        {
            for(int v:adj.get(u))
            {
                if(u < v)
                {


                    if(find(u)==find(v))
                    {
                        return true;
                    }
                    union(u,v);
                }
            }
        }

        return false;

    }

    int find(int node)
    {
        if(node == parent[node])
        {
            return node;
        }

        return parent[node] = find(parent[node]);
    }

    void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);


        if(rootX==rootY)
            return;

        if(rank[rootX]>rank[rootY])
        {
            parent[rootY] = rootX;
        }
        else if(rank[rootY]>rank[rootX])
        {
            parent[rootX] = rootY;
        }
        else
        {

            parent[rootY] = rootX;
            rank[rootX]++;

        }

    }


}