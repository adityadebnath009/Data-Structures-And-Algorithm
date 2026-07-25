package LeetCode.BinaryTree;

/**
 * Platform: LeetCode
 * Problem ID: 653
 * Problem Name: Two Sum IV - Input is a BST
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/two-sum-iv---input-is-a-bst/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0653_TwoSumIvInputIsABst {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0653_TwoSumIvInputIsABst...");
    }

    // TODO: Write solution method here
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();

        return inorder(root, set, k);

    }
    boolean inorder(TreeNode root, Set<Integer> set, int k)
    {
        if(root==null)
        {
            return false;
        }
        if(inorder(root.left, set, k)==true)
        {
            return true;
        }
        int value = root.val;

        if(set.contains(k-value))
        {
            return true;
        }
        set.add(value);

        return inorder(root.right, set, k);

    }
}