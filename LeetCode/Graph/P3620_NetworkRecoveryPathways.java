/**
 * Platform: LeetCode
 * Problem ID: 3620
 * Problem Name: Network Recovery Pathways
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/network-recovery-pathways/
 * 
 * Complexity:
 * - Time Complexity: O((V+E)logV⋅logW)
 * - Space Complexity: O(V + E)
 * 
 * Approach:
 * // TODO: Djikstra's Algorithm + Binary Search on edge costs
 *  we will apply binary search on edge cost and include those edges which weight is >=mid
 *  if the path is valid then we will try for higher edge cost that is store ans = mid and left  = mid + 1 otherwise high = mid - 1;
 *  because our task is maximize the edge cost such that total cost is within K that is <=k
 *
 *  Maximize the edge cost while keeping the total cost within the bounds, i.e., less than or equal to k.
 */

public class P3620_NetworkRecoveryPathways {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P3620_NetworkRecoveryPathways...");
    }

    // TODO: Write solution method here
}
class Solution {
    class Pair{
        int node;
        long cost;
        Pair(int node, long cost)
        {
            this.node = node;
            this.cost = cost;
        }

    }
    class Edge{
        int node;
        int weight;
        Edge(int node, int weight)
        {
            this.node = node;
            this.weight = weight;
        }
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        for(int i = 0;i < n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int maxEdgeCost = Integer.MIN_VALUE;

        for(int edge[]: edges)
        {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            maxEdgeCost = Math.max(cost, maxEdgeCost);
            adj.get(u).add(new Edge(v, cost));//U----cost--->V
        }

        int low = 0;
        int high = maxEdgeCost;
        int ans = Integer.MIN_VALUE;

        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(check(adj, online, mid, k, n))
            {
                ans = Math.max(mid, ans);
                low = mid + 1;

            }
            else
            {
                high = mid - 1;
            }
        }

        return ans == Integer.MIN_VALUE?-1:ans;



    }
    boolean check(ArrayList<ArrayList<Edge>> adj, boolean online[], int costTH, long k, int n)
    {
        long dist[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.cost,b.cost));

        //source = 0
        //destination = n-1

        dist[0] = 0;
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();

            int currNode = p.node;
            long currCost = p.cost;

            if(currCost > k)
            {
                return false;
            }
            if(currNode == n - 1)
            {
                return true;
            }

            if(currCost > dist[currNode])
            {
                continue;
            }

            for(Edge neighNode: adj.get(currNode))
            {
                int nextNode = neighNode.node;
                int nextCost = neighNode.weight;
                if(online[nextNode]==false)
                    continue;
                if(nextCost<costTH)
                    continue;

                if(currCost + nextCost < dist[nextNode])
                {
                    dist[nextNode] = currCost + nextCost;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }

        }

        return false;

    }
}