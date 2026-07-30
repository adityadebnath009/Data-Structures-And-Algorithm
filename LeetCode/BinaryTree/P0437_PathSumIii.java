package LeetCode.BinaryTree;

/**
 * Platform: LeetCode
 * Problem ID: 437
 * Problem Name: Path Sum III
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/path-sum-iii/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0437_PathSumIii {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0437_PathSumIii...");
    }

    // TODO: Write solution method here
}
class Solution {
    int count;
    HashMap<Long, Integer> map;
    public int pathSum(TreeNode root, int target) {
        count = 0;
        map = new HashMap<>();
        map.put(0L, 1);

        solve(root, 0, target);

        return count;


    }
    void solve(TreeNode root, long currentSum, int target)
    {
        if(root==null)
            return;

        currentSum += root.val;


        count += map.getOrDefault(currentSum-target, 0);

        map.put(currentSum, map.getOrDefault(currentSum,0) + 1);

        solve(root.left, currentSum, target);
        solve(root.right, currentSum, target);

        if(map.containsKey(currentSum))
        {
            map.put(currentSum, map.get(currentSum) - 1);
            if(map.get(currentSum)==0)
            {
                map.remove(currentSum);
            }
        }

    }
}