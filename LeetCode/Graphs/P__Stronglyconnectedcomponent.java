/**
 * Platform: LeetCode
 * Problem ID: 
 * Problem Name: StronglyConnectedComponent
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/stronglyconnectedcomponent/
 * 
 * Complexity:
 * - Time Complexity: O(N + M)
 * - Space Complexity: O(N + M)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P__Stronglyconnectedcomponent {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P__Stronglyconnectedcomponent...");
    }

    // TODO: Write solution method here
}
class Solution {

    int captainAmerica(int N, int M, int V[][]) {

        List<List<Integer>> forward = new ArrayList<>();

        List<List<Integer>> backward = new ArrayList<>();

        for(int  i = 0;i < N + 1;i++)
        {
            forward.add(new ArrayList<>());
            backward.add(new ArrayList<>());
        }

        for(int edge[]:V)
        {
            int u = edge[0];
            int v = edge[1];
            forward.get(u).add(v);
            backward.get(v).add(u);
        }

        boolean visited[] = new boolean[N+1];
        Stack<Integer> s = new Stack<>();

        for(int i = 1;i <= N;i++)
        {
            if(visited[i]==false)
            {
                dfs1(i, N, visited, s, forward);
            }
        }


        Arrays.fill(visited, false);
        int maxSize = 0;
        ArrayList<ArrayList<Integer>> scc = new ArrayList<>();

        while(!s.isEmpty())
        {
            int node = s.pop();
            ArrayList<Integer> subList = new ArrayList<>();
            if(visited[node]==false)
            {
                dfs2(node, backward, subList, visited);
                scc.add(subList);
            }



        }
        int comp[] = new int [N + 1];
        for(int i = 0;i < scc.size();i++)
        {
            for(int node : scc.get(i))
            {
                comp[node] = i;
            }
        }

        boolean pointOut[] = new boolean[scc.size()];

        for(int u = 1;u <= N;u++)
        {
            for(int v:forward.get(u))
            {
                if(comp[u]!=comp[v])
                {
                    pointOut[comp[u]] = true;
                }
            }
        }

        int targetComp = -1;
        int sinkCount=0;
        for(int i = 0;i < scc.size();i++)
        {
            if(!pointOut[i])
            {
                sinkCount++;
                targetComp = i;
            }
        }
        return sinkCount==1?scc.get(targetComp).size():0;




    }
    void dfs2(int node, List<List<Integer>> adj, ArrayList<Integer> subList, boolean visited[])
    {
        visited[node] = true;
        subList.add(node);

        for(int neigh: adj.get(node))
        {
            if(visited[neigh]==false)
            {
                dfs2(neigh, adj, subList, visited);
            }
        }


    }

    void dfs1(int node, int N, boolean visited[], Stack<Integer> s, List<List<Integer>> adj)
    {
        visited[node] = true;

        for(int neigh: adj.get(node))
        {
            if(visited[neigh]==false)
            {
                dfs1(neigh, N, visited, s, adj);
            }
        }

        s.push(node);

    }

}