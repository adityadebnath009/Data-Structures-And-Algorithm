package LeetCode.Array;

/**
 * Platform: LeetCode
 * Problem ID: 3559
 * Problem Name: Number of Ways to Assign Edge Weights II
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P3559_NumberOfWaysToAssignEdgeWeightsIi {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P3559_NumberOfWaysToAssignEdgeWeightsIi...");
    }

    // TODO: Write solution method here
}
class Solution {
    private static int MAX = 100005; // for int
    private static final int MOD = 1000000007;
    private static long[] pow2 = new long[MAX];
    static {

        pow2[0] = 1;
        for (int i = 1; i < MAX; i++) {
            pow2[i] = (pow2[i - 1] * 2l)%MOD;
        }
    }

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int nodes = edges.length + 1;
        int rows = nodes;//nodes --> 0 to n-1
        int cols = (int) (Math.log(nodes) / Math.log(2)) + 1;
        int ancestor[][] = new int[rows][cols];
        int depth[] = new int[nodes];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            adj.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ancestor[i][j] = -1;
            }
        }
        parent(ancestor, adj, 0, -1);
        dfs(adj, depth, 0, -1, 0);
        populateAncestor(ancestor, rows, cols);

        int ans[] = new int[queries.length];
        int idx = 0;
        for (int query[] : queries) {
            int u = query[0] - 1;
            int v = query[1] - 1;

            int lcaNode = LCA(ancestor, depth, u, v);

            int k = depth[u] + depth[v] - 2 * depth[lcaNode];

            if (k == 0)
                ans[idx++] = 0;
            else
                ans[idx++] = (int) (pow2[k - 1]%MOD);

        }
        return ans;

    }

    int LCA(int ancestor[][], int depth[], int u, int v) {
        int d;
        int ansV;
        int ansU;
        if (depth[u] < depth[v]) {
            d = depth[v] - depth[u];
            //push v to upward;
            ansV = getKthAncestor(d, ancestor, v, ancestor[0].length);
            //u and v are at the same level
            ansU = u;
        } else {
            d = depth[u] - depth[v];
            ansU = getKthAncestor(d, ancestor, u, ancestor[0].length);
            ansV = v;
        }
        if (ansU == ansV)
            return ansU;

        for (int j = ancestor[0].length - 1; j >= 0; j--) {
            if (ancestor[ansU][j] != ancestor[ansV][j]) {
                ansU = ancestor[ansU][j];
                ansV = ancestor[ansV][j];
            }
        }
        return ancestor[ansU][0];

    }

    int getKthAncestor(int k, int ancestor[][], int node, int cols) {

        for (int j = 0; j < cols; j++) {
            if ((k & (1 << j)) != 0) {
                node = ancestor[node][j];

                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;

    }

    void populateAncestor(int ancestor[][], int rows, int cols) {
        for (int j = 1; j < cols; j++) {
            for (int nodes = 0; nodes < rows; nodes++) {
                if (ancestor[nodes][j - 1] != -1)
                    ancestor[nodes][j] = ancestor[ancestor[nodes][j - 1]][j - 1];
            }
        }
    }

    void parent(int ancestor[][], List<List<Integer>> adj, int curr, int prev) {
        ancestor[curr][0] = prev;

        for (int neigh : adj.get(curr)) {
            if (prev == neigh) {
                continue;
            }
            parent(ancestor, adj, neigh, curr);
        }

    }

    void dfs(List<List<Integer>> adj, int depth[], int curr, int prev, int path) {
        depth[curr] = path;

        for (int neigh : adj.get(curr)) {
            if (neigh == prev)
                continue;
            dfs(adj, depth, neigh, curr, path + 1);
        }
    }
}