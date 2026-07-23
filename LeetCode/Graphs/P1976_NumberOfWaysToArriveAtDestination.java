package LeetCode.Graphs;

/**
 * Platform: LeetCode
 * Problem ID: 1976
 * Problem Name: Number of Ways to Arrive at Destination
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
 * 
 * Complexity:
 * - Time Complexity: O((V+E)LogE)
 * - Space Complexity: O(V + E)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P1976_NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1976_NumberOfWaysToArriveAtDestination...");
    }

    // TODO: Write solution method here
}
class Solution {
    private final int MOD = 1000000007;
    class Edge{
        int node;
        long weight;
        Edge(int node, long weight)
        {
            this.node = node;
            this.weight = weight;
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<List<Edge>> adj = new ArrayList<>();

        for(int i = 0;i < n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int road[]:roads)
        {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> Long.compare(a.weight,b.weight));
        pq.add(new Edge(0,0));

        long time[] = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        long ways[] = new long[n];

        ways[0] = 1;
        time[0] = 0;

        while(!pq.isEmpty())
        {
            Edge e = pq.poll();
            int node = e.node;
            long weight = e.weight;

            if(time[node] < weight)
                continue;

            for(Edge nextNeigh:adj.get(node))
            {
                int nextNode = nextNeigh.node;
                long cost = nextNeigh.weight;

                if(cost + time[node] < time[nextNode])
                {
                    time[nextNode] = cost + time[node];
                    ways[nextNode] = ways[node];

                    pq.add(new Edge(nextNode, time[nextNode]));
                }
                else if(cost + time[node] == time[nextNode])
                {
                    ways[nextNode] = (ways[nextNode] + ways[node])%MOD;

                }

            }

        }


        return (int)ways[n-1];


    }
}