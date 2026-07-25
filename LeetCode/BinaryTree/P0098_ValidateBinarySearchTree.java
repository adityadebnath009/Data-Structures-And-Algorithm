package LeetCode.BinaryTree;

/**
 * Platform: LeetCode
 * Problem ID: 98
 * Problem Name: Validate Binary Search Tree
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0098_ValidateBinarySearchTree {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0098_ValidateBinarySearchTree...");
    }

    // TODO: Write solution method here
}


// class Solution {
//     Integer prev;
//     public boolean isValidBST(TreeNode root) {
//         prev = null;
//         return inorder(root);


//     }
//     public boolean inorder(TreeNode root)
//     {
//         if(root==null) return true;

//         boolean left = inorder(root.left);

//         if(!left) return false;

//         if(prev!=null && prev>=root.val)
//         {
//             return false;
//         }

//         prev = root.val;

//         return inorder(root.right);


//     }
// }

class Solution {

    public boolean isValidBST(TreeNode root) {

        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);


    }
    public boolean isValid(TreeNode root, long min, long max)
    {
        if(root==null)
        {
            return true;
        }

        if(root.val<=min || root.val>=max)
        {
            return false;
        }

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);


    }
}
