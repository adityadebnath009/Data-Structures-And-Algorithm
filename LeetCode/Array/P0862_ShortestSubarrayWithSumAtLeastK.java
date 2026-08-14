package LeetCode.Array;

/**
 * Platform: LeetCode
 * Problem ID: 862
 * Problem Name: Shortest Subarray with Sum at Least K
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(N)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0862_ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0862_ShortestSubarrayWithSumAtLeastK...");
    }

    // TODO: Write solution method here
}
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int prefix[] = new int[n+1];
        prefix[0] = 0;

        for(int i = 0;i < n;i++)
        {
            prefix[i+1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int maxLength = Integer.MAX_VALUE;

        int j = 0;
        while(j <= n)
        {
            while(!dq.isEmpty() && prefix[j] - prefix[dq.peekFirst()] >= k)
            {
                maxLength = Math.min(maxLength, j - dq.pollFirst());
            }
            while(!dq.isEmpty() && prefix[j] <= prefix[dq.peekLast()])
            {
                dq.pollLast();
            }
            dq.offerLast(j);
            j++;
        }

        return maxLength==Integer.MAX_VALUE?-1:maxLength;

    }
}