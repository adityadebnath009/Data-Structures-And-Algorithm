package LeetCode.BinaryTree;

/**
 * Platform: LeetCode
 * Problem ID: 124
 * Problem Name: Max Path Sum
 * Difficulty: Easy
 * 
 * Link: https://leetcode.com/problems/max-path-sum/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0124_MaxPathSum {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0124_MaxPathSum...");
    }

    // TODO: Write solution method here
}


class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {



        sum(root);

        return maxSum;


    }

    int  sum(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        //path sum through the curr Node
        maxSum = Math.max(root.val + leftSum + rightSum,maxSum);

        int sum = root.val + Math.max(leftSum,rightSum);




        return sum<0?0:sum;

    }
}