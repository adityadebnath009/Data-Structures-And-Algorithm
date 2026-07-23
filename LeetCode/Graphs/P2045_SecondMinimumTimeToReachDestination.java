package LeetCode.Graphs;

/**
 * Platform: LeetCode
 * Problem ID: 2045
 * Problem Name: Second Minimum Time to Reach Destination
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/second-minimum-time-to-reach-destination/
 * 
 * Complexity:
 * - Time Complexity: O((V+E)LogE)
 * - Space Complexity: O(V + E)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P2045_SecondMinimumTimeToReachDestination {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P2045_SecondMinimumTimeToReachDestination...");
    }

    // TODO: Write solution method here
}

class Solution {
    class Pair{
        int node;
        int arrivalTime;
        Pair(int node, int arrivalTime)
        {
            this.node = node;
            this.arrivalTime = arrivalTime;
        }
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int edge[]:edges)
        {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int best[] = new int[n];
        int secondBest[] = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);
        Arrays.fill(secondBest, Integer.MAX_VALUE);

        best[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.arrivalTime - b.arrivalTime);
        pq.add(new Pair(0,0));

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int node = p.node;
            int arrivalTime = p.arrivalTime;

            if(secondBest[node] < arrivalTime)
            {
                continue;
            }

            for(int neigh:adj.get(node))
            {
                int interval = arrivalTime/change;
                int newTime = arrivalTime + time;
                if(interval%2!=0)
                {
                    int wait = ((interval + 1)*change) - arrivalTime;
                    newTime += wait;
                }
                if(newTime < best[neigh])
                {
                    secondBest[neigh] = best[neigh];
                    best[neigh] = newTime;
                    pq.add(new Pair(neigh,newTime));
                }
                else if(best[neigh]<newTime && newTime<secondBest[neigh])
                {
                    secondBest[neigh] = newTime;
                    pq.add(new Pair(neigh,newTime));

                }
            }
        }
        return secondBest[n-1];


    }
}

