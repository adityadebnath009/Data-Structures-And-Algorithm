/**
 * Platform: LeetCode
 * Problem ID: 1004
 * Problem Name: Maximum Consecutive Ones III
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/maximum-consecutive-ones-iii/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P1004_MaximumConsecutiveOnesIii {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P1004_MaximumConsecutiveOnesIii...");
    }

    // TODO: Write solution method here

        public int longestOnes(int[] nums, int k) {
            int i = 0;
            int j = 0;
            int n = nums.length;
            int cnt_k = 0;
            int res = 0;

            while(j<n)
            {
                if(nums[j]==0)
                {
                    cnt_k++;
                }
                while(cnt_k > k)
                {
                    if(nums[i]==0)
                    {
                        cnt_k--;
                    }
                    i++;
                }
                if(cnt_k<=k)
                {
                    res = Math.max(res, j - i + 1);
                }
                j++;
            }

            return res;



        }

}
