/**
 * Platform: LeetCode
 * Problem ID: 525
 * Problem Name: Longest subarray with an equal number of 0s and 1s
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/longest-subarray-with-an-equal-number-of 0s-and 1s/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0525_LongestSubarrayWithAnEqualNumberOf0sAnd1s {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0525_LongestSubarrayWithAnEqualNumberOf0sAnd1s...");
    }

    // TODO: Write solution method here
}
class Solution {
    public int findMaxLength(int[] nums) {

        int prefix = 0;
        int maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();


        for(int i = 0;i < nums.length;i++)
        {
            prefix += nums[i]==1?1:-1;

            if(prefix==0)
            {
                maxLen = i + 1;
            }
            if(map.containsKey(prefix))
            {
                maxLen = Math.max(maxLen, i - map.get(prefix));
            }
            else
            {
                map.put(prefix, i);
            }
        }

        return maxLen;


    }
}