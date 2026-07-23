/**
 * Platform: LeetCode
 * Problem ID: 1514
 * Problem Name: Path With Maximum Probability
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/path-with-maximum-probability/
 * 
 * Complexity:
 * - Time Complexity: O((V+E)logE)
 * - Space Complexity: O(V+E)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P1514_PathWithMaximumProbability {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1514_PathWithMaximumProbability...");
    }

    // TODO: Write solution method here
}
class Solution {
    class Pair{
        int node;
        double cost;
        Pair(int node, double cost)
        {
            this.node = node;
            this.cost = cost;
        }
    }
    class Edge{
        int node;
        double cost;
        Edge(int node, double cost)
        {
            this.node = node;
            this.cost = cost;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i < edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            double cost = succProb[i];

            adj.get(u).add(new Edge(v, cost));
            adj.get(v).add(new Edge(u, cost));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.cost, a.cost));

        double dist[] = new double[n];
        Arrays.fill(dist, Double.MIN_VALUE);
        dist[start_node] = 1;
        pq.add(new Pair(start_node, 1));

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int currNode = p.node;
            double currCost = p.cost;

            if(dist[currNode] > currCost)
            {
                continue;
            }

            for(Edge neigh:adj.get(currNode))
            {
                int nextNode = neigh.node;
                double nextCost = neigh.cost;

                if(nextCost*currCost>dist[nextNode])
                {
                    dist[nextNode] = nextCost*currCost;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        return dist[end_node];

    }
}