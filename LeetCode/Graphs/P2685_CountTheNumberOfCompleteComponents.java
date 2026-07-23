/**
 * Platform: LeetCode
 * Problem ID: 2685
 * Problem Name: Count the Number of Complete Components
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/count-the-number-of-complete-components/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P2685_CountTheNumberOfCompleteComponents {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P2685_CountTheNumberOfCompleteComponents...");
    }

    // TODO: Write solution method here
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i < n;i++)
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
        int cnt =0 ;

        boolean visited[] = new boolean[n];
        for(int i = 0;i < n;i++)
        {
            if(visited[i]==false && countCompleteComp(adj, visited, i))
            {
                cnt++;
            }
        }
        return cnt;
    }
    boolean countCompleteComp(List<List<Integer>> adj, boolean visited[], int node)
    {
        visited[node] = true;
        int cntNode = 0;
        int cntEdge = 0;
        Queue<Integer> q= new LinkedList<>();
        q.add(node);


        while(!q.isEmpty())
        {
            int currNode = q.poll();
            cntNode++;

            for(int nextNode:adj.get(currNode))
            {
                cntEdge++;
                if(visited[nextNode]==false)
                {
                    visited[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }
        cntEdge = cntEdge/2;

        return cntEdge==(cntNode*(cntNode-1))/2;

    }
}