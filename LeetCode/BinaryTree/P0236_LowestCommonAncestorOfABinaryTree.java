package LeetCode.Array;

/**
 * Platform: LeetCode
 * Problem ID: 236
 * Problem Name: Lowest Common Ancestor of a Binary Tree
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0236_LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0236_LowestCommonAncestorOfABinaryTree...");
    }

    // TODO: Write solution method here
}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null; // reached end, found nothing
//        This handles when the current node itself is one of p or q. For example, if p is an ancestor of q, then p is the LCA.
        if(root == p || root == q) return root; // found p or q, send it up

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);


//        p and q are in different subtrees
//        One node is found in the left subtree and the other is found in the right subtree.
        if(left != null && right != null) return root;


//        p and q are in the same subtree
//        Both nodes are found either on the left side or on the right side.
        return left != null ? left : right;



    }
}
