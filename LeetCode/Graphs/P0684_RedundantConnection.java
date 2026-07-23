/**
 * Platform: LeetCode
 * Problem ID: 684
 * Problem Name: Redundant Connection
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/redundant-connection/
 * 
 * Complexity:
 * - Time Complexity: O(N*alpha(N))
 * - Space Complexity: O(N)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0684_RedundantConnection {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0684_RedundantConnection...");
    }

    // TODO: Write solution method here
}


class Solution {
    int parent[];
    int rank[];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n+1];
        rank = new int[n+1];

        for(int i = 0;i < n+1;i++)
        {
            parent[i] = i;
        }
        int ans[] = {};
        for(int edge[]:edges)
        {
            int u = edge[0];
            int v = edge[1];

            if(find(u)==find(v))
            {
                ans = edge;
                break;
            }
            union(u, v);
        }

        return ans;


    }
    void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX==rootY)
        {
            return;
        }
        if(rank[rootX] < rank[rootY])
        {
            parent[rootX] = rootY;
        }
        else if(rank[rootX] > rank[rootY])
        {
            parent[rootY] = rootX;
        }
        else
        {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
    int find(int node)
    {
        if(node==parent[node])
        {
            return node;
        }

        return parent[node] = find(parent[node]);
    }
}