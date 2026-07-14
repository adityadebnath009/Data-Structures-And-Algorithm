package LeetCode.Array;

/**
 * Platform: LeetCode
 * Problem ID: 1483
 * Problem Name: Kth Ancestor of a Tree Node
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
 * 
 * Complexity:
 * - Time Complexity: O(logN)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P1483_KthAncestorOfATreeNode {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1483_KthAncestorOfATreeNode...");
    }

    // TODO: Write solution method here
}

class TreeAncestor {
    int rows;
    int cols;
    int ancestor[][];

    public TreeAncestor(int n, int[] parent) {

        this.rows = n;
        this.cols = (int) Math.round(Math.log(n) / Math.log(2)) + 1;
        this.ancestor = new int[rows][cols];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < cols; j++) {
                ancestor[i][j] = -1;
            }
        }

        for(int i = 0;i < n;i++)
        {
            ancestor[i][0] = parent[i];
        }
        for(int j = 1;j < cols;j++)
        {
            for(int node = 0;node <= n-1;node++)
            {
                if(ancestor[node][j-1]!=-1)
                    ancestor[node][j] = ancestor[ancestor[node][j-1]][j-1];
            }
        }

    }

    public int getKthAncestor(int node, int k) {

        for(int j = 0;j < cols && node!=-1 ;j++)
        {
            if((k & (1<<j) ) != 0)
            {
                node = ancestor[node][j];
                if(node==-1)
                {
                    return -1;
                }
            }
        }

        return node;


    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */