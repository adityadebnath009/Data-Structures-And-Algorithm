package LeetCode.BinaryTree;

/**
 * Platform: LeetCode
 * Problem ID: 1008
 * Problem Name: Construct Binary Search Tree from Preorder Traversal
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P1008_ConstructBinarySearchTreeFromPreorderTraversal {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1008_ConstructBinarySearchTreeFromPreorderTraversal...");
    }

    // TODO: Write solution method here
}


//Naive Approach
//One thing we learn is that, given a preorder traversal of a binary search tree,
// we can simply traverse the elements and insert them in the same order,
// thereby generating the binary search tree.
//The worst case occurs when the array is sorted, resulting in O\(n^2\) time. In other situations, the average case is O(n \log n\).
TreeNode root = null;

for (int val : preorder) {
root = insert(root, val);
}



//Optimal Approach
class Solution {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    TreeNode build(int preorder[], int min, int max)
    {
        if(index==preorder.length)
        {
            return null;
        }
        int val = preorder[index];
        if(min >= val || val >= max)
        {
            return null;
        }
        index++;
        TreeNode root = new TreeNode(val);

        root.left = build(preorder,min, val);
        root.right = build(preorder, val, max);

        return root;
    }
}