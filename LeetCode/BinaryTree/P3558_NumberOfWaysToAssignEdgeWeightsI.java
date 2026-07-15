package LeetCode.BinaryTree;

/**
 * Platform: LeetCode
 * Problem ID: 3558
 * Problem Name: Number of Ways to Assign Edge Weights I
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P3558_NumberOfWaysToAssignEdgeWeightsI {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P3558_NumberOfWaysToAssignEdgeWeightsI...");
    }

    // TODO: Write solution method here
}
class Solution {
    private final int MOD = 1000000007;
    public int assignEdgeWeights(int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        int n = edges.length;

        for(int i = 0;i <= n+1;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int edge[]:edges)
        {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);


        }
        int k = dfs(adj, -1, 1);

        return exp(2, k - 1);
    }
    int dfs(List<List<Integer>> adj, int prev,int curr)
    {
        int dist = 0;

        for(int neigh:adj.get(curr))
        {
            if(prev==neigh)
            {
                continue;
            }
            dist = Math.max(dist, 1 + dfs(adj, curr, neigh));
        }

        return dist;

    }
    int exp(int base, int pow)
    {
        long ans = 1;
        for(int i = 1;i <= pow;i++)
        {
            ans = (ans%MOD)*(base%MOD);
        }
        return (int)ans%MOD;
    }
}