/**
 * Platform: LeetCode
 * Problem ID: 2492
 * Problem Name: Minimum Score of a Path Between Two Cities
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P2492_MinimumScoreOfAPathBetweenTwoCities {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P2492_MinimumScoreOfAPathBetweenTwoCities...");
    }

    // TODO: Write solution method here
}

class Solution {
    class Edge{
        int node;
        int weight;
        Edge(int node, int weight)
        {
            this.node = node;
            this.weight = weight;
        }
    }
    public int minScore(int n, int[][] roads) {

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        for(int i = 0;i < n + 1;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int road[]:roads)
        {
            int u = road[0];
            int v = road[1];
            int cost = road[2];
            adj.get(u).add(new Edge(v, cost));
            adj.get(v).add(new Edge(u, cost));
        }

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n+1];

        visited[1] = true;
        q.add(1);
        int ans = Integer.MAX_VALUE;

        while(!q.isEmpty())
        {
            int node = q.poll();

            for(Edge e: adj.get(node))
            {
                int nextNode = e.node;
                int weight = e.weight;
                ans = Math.min(ans, weight);
                if(!visited[nextNode])
                {
                    visited[nextNode] = true;
                    q.add(nextNode);

                }
            }
        }
        return ans;

    }
}
