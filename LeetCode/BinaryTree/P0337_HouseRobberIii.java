package LeetCode.BinaryTree;

/**
 * Platform: LeetCode
 * Problem ID: 337
 * Problem Name: House Robber III
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/house-robber-iii/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0337_HouseRobberIii {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0337_HouseRobberIii...");
    }

    // TODO: Write solution method here
}

class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();

        return solve(root, map);

    }
    int solve(TreeNode root, Map<TreeNode, Integer> map)
    {
        if(root==null)
        {
            return 0;
        }

        if(map.containsKey(root))
        {
            return map.get(root);
        }
        int sum = 0;

        if(root.left!=null)
        {
            sum += solve(root.left.left, map) + solve(root.left.right, map);
        }
        if(root.right!=null)
        {
            sum += solve(root.right.left, map) + solve(root.right.right, map);
        }

        sum = Math.max(sum + root.val, solve(root.left, map) + solve(root.right, map));
        map.put(root, sum);
        return sum;
    }
}
//Approach 2nd: Greedy
class Solution {

    public int rob(TreeNode root) {

        int[] ans = dfs(root);

        return Math.max(ans[0], ans[1]);
    }

    private int[] dfs(TreeNode root) {

        if (root == null)
            return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int rob = root.val + left[1] + right[1];

        int notRob =
                Math.max(left[0], left[1]) +
                        Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }
}