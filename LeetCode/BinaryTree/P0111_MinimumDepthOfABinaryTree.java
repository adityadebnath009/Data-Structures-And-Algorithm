package LeetCode.BinaryTree;

/**
 * Platform: LeetCode
 * Problem ID: 111
 * Problem Name: Minimum Depth of a Binary Tree
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/minimum-depth-of-a-binary-tree/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0111_MinimumDepthOfABinaryTree {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0111_MinimumDepthOfABinaryTree...");
    }

    // TODO: Write solution method here
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {


        if(root==null)
        {

            return 0;
        }
        if(root.left == null && root.right==null)
        {
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);


        int sum = 0;
        if((root.right==null && root.left!=null) || (root.right!=null && root.left==null))
        {
            sum = left + right + 1;
        }
        else
        {
            sum = Math.min(left,right) + 1;
        }

        return sum;

    }
}
