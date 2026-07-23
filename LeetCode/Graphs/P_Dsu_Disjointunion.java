/**
 * Platform: GeeksForGeeks
 * Problem ID: DSU
 * Problem Name: DisjointUnion
 * Difficulty: Medium
 * 
 * Link: Link to problem
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P_Dsu_Disjointunion {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P_Dsu_Disjointunion...");
    }

    // TODO: Write solution method here
}
class Solution {
    int parent[];
    int rank[];
    public ArrayList<Integer> DSU(int n, int[][] queries) {
        // code here
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 1;i <= n;i++)
        {
            parent[i] = i;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0;i < queries.length; i++)
        {
            int type = queries[i][0];

            if(type==1)
            {
                int x = queries[i][1];
                int y = queries[i][2];
                union(x, y);

            }
            else
            {
                int x = queries[i][1];
                int f = find(x);
                ans.add(f);
            }
        }
        return ans;


    }
    void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX==rootY)
            return;

        if(rank[rootX] < rank[rootY])
        {
            parent[rootX] = rootY;
        }
        else if(rank[rootX] > rank[rootY])
        {
            parent[rootY] = rootX;
        }
        else
        {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
    int find(int i)
    {
        if(i == parent[i])
            return i;

        return parent[i] = find(parent[i]);
    }

}

