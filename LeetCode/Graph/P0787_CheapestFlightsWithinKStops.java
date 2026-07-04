/**
 * Platform: LeetCode
 * Problem ID: 787
 * Problem Name: Cheapest Flights Within K Stops
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO:
 * Build an adjacency list storing (neighbor, flight cost).
 * Use a queue starting with (src, 0).
 * Maintain minCost[], initialized to infinity, to track the cheapest known cost to each node.
 * Process the queue level by level, where each level represents one additional flight/edge.
 *
 * For every neighbor, calculate:
 *
 * newCost = currCost + flightCost;
 * If newCost < minCost[neighbor], update it and add the new state to the queue.
 * Continue only up to the allowed number of stops (k + 1 edges/flights) or (<=k).
 * Return the minimum cost to dst, or -1 if it is unreachable within the stop limit.
 */

public class P0787_CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0787_CheapestFlightsWithinKStops...");
    }

    // TODO: Write solution method here
}
class Solution {
    class Pair{

        int node;
        int cost;
        int stops;
        Pair(int node, int cost)
        {
            this.node = node;
            this.cost = cost;
        }
        Pair(int node,int cost, int stops)
        {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0;i < n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] flight:flights)
        {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];

            adj.get(u).add(new Pair(v,w));
        }

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(src,0,0));

        int minCost[] = new int[n];
        minCost[src] = 0;
        Arrays.fill(minCost,Integer.MAX_VALUE);

        int stops = 0;

        while(!q.isEmpty() && stops<=k)
        {
            int size = q.size();

            while(size-- > 0)
            {

                Pair p = q.poll();


                int currFlight = p.node;
                int currCost = p.cost;
                int currStop = p.stops;

                for(Pair nextFlight:adj.get(currFlight))
                {
                    int nextF = nextFlight.node;
                    int travelCost = nextFlight.cost;

                    if(currCost + travelCost < minCost[nextF])
                    {
                        minCost[nextF] = currCost + travelCost;
                        q.add(new Pair(nextF,minCost[nextF],currStop+1));


                    }
                }
            }
            stops++;
        }


        return minCost[dst]==Integer.MAX_VALUE?-1:minCost[dst];



    }
}