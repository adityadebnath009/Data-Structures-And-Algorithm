package LeetCode.BinaryTree;

/**
 * Platform: LeetCode
 * Problem ID: 669
 * Problem Name: Trim a Binary Search Tree
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/trim-a-binary-search-tree/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0669_TrimABinarySearchTree {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0669_TrimABinarySearchTree...");
    }

    // TODO: Write solution method here
}
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if(root==null)
            return null;

        if(root.val < low)
        {
            return trimBST(root.right, low, high);
        }
        if(root.val > high)
        {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;

    }
}