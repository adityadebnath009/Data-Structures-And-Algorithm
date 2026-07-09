/**
 * Platform: LeetCode
 * Problem ID: 685
 * Problem Name: Redundant Connection II
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/redundant-connection-ii/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * //
 * We first compute the indegree of every node and identify whether any node has indegree 2.
 * Such a node has two parents, so there are two candidate incoming edges that may be redundant.
 * These two edges can be found by directly scanning the edge list.
 *
 * There are two main cases:
 *
 * If no node has indegree 2, then the graph contains only a cycle. We process the edges using a disjoint-set structure.
 * The first edge whose endpoints already belong to the same set creates the cycle and is the redundant edge.
 *
 * If a node has indegree 2, let its two incoming edges be A and B, where B appears later in the edge list.
 * We first temporarily ignore B and process all remaining edges using a disjoint-set structure.
 *
 * If the remaining edges form a valid connected structure without a cycle, then B is the redundant edge.
 * If a cycle still exists, then A is the redundant edge.
 * Alternatively, for each candidate edge, we can temporarily remove it and use BFS or DFS to test whether the remaining graph is connected.
 * However, using Union-Find is more efficient and directly detects cycles while processing the edges.
 *
 * The Union-Find approach takes approximately O(n α(n)) time, which is effectively linear for practical input sizes.
 */

public class P0685_RedundantConnectionIi {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0685_RedundantConnectionIi...");
    }

    // TODO: Write solution method here
}


class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length;

        int[] indegree = new int[n + 1];

        int[] A = null;
        int[] B = null;


        for (int[] edge : edges) {

            int v = edge[1];
            indegree[v]++;

            if (indegree[v] == 2) {


                for (int[] e : edges) {

                    if (e[1] == v) {

                        if (A == null) {
                            A = e;
                        } else {
                            B = e;
                            break;
                        }
                    }
                }

                break;
            }
        }




        if (B == null) {

            UnionFind uf = new UnionFind(n + 1);

            for (int[] edge : edges) {

                if (!uf.union(edge[0], edge[1])) {
                    return edge;
                }
            }
        }




        UnionFind checkB = new UnionFind(n + 1);

        boolean cycle = false;

        for (int[] edge : edges) {

            if (edge == B) {
                continue;
            }

            if (!checkB.union(edge[0], edge[1])) {
                cycle = true;
                break;
            }
        }

        if (!cycle) {
            return B;
        }

        return A;
    }
}


class UnionFind {

    int[] parent;
    int[] rank;

    UnionFind(int n) {

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }


    int find(int node) {

        if (parent[node] == node) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }


    boolean union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        // Cycle detected
        if (rootX == rootY) {
            return false;
        }

        if (rank[rootX] > rank[rootY]) {

            parent[rootY] = rootX;

        } else if (rank[rootX] < rank[rootY]) {

            parent[rootX] = rootY;

        } else {

            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }
}