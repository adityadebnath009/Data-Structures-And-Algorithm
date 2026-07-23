/**
 * Platform: LeetCode
 * Problem ID: 
 * Problem Name: Number of Conected Components
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/number-of-conected-components/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P__NumberOfConectedComponents {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P__NumberOfConectedComponents...");
    }

    // TODO: Write solution method here
}

class Solution {
    int parent[];
    int rank[];


    int countConnected(int V, ArrayList<ArrayList<Integer>> edges) {
        // code here
        parent = new int[V];
        rank = new int[V];

        for(int i = 0;i < V;i++)
        {
            parent[i] = i;
        }
        for(ArrayList<Integer> edge: edges)
        {
            int u = edge.get(0);
            int v = edge.get(1);

            union(u, v);
        }

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0;i < V;i++)
        {
            map.computeIfAbsent(find(i), k -> new ArrayList<>()).add(i);
        }


        return map.size();
    }
    int find(int node)
    {
        if(node == parent[node])
        {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if(rank[rootX] > rank[rootY])
        {
            parent[rootY] = rootX;
        }
        else if(rank[rootX] < rank[rootY])
        {
            parent[rootX] = rootY;
        }
        else
        {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}