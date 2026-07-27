package LeetCode.BinaryTree;

/**
 * Platform: LeetCode
 * Problem ID: 103
 * Problem Name: Binary Tree Zigzag Level Order Traversal
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0103_BinaryTreeZigzagLevelOrderTraversal...");
    }

    // TODO: Write solution method here
}
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int lvl = 0;


        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            while(size-- > 0)
            {
                TreeNode curr = q.poll();
                if(lvl%2==0)
                {
                    subList.addLast(curr.val);
                }
                else
                {
                    subList.addFirst(curr.val);
                }


                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }

            }
            ans.add(subList);
            lvl++;
        }
        return ans;

    }
}
