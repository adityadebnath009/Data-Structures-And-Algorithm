/**
 * Platform: LeetCode
 * Problem ID: 215
 * Problem Name: Top K elements
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/top-k-elements/
 * 
 * Complexity:
 * - Time Complexity: O(nlogk)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0215_TopKElements {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0215_TopKElements...");
    }

    // TODO: Write solution method here
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //To find kth Larget
        //We will use min-heap

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //By default it implements min heap

        int cnt = 0;

        for(int i = 0;i < nums.length;i++)
        {
            if(cnt<k)
            {

                pq.add(nums[i]);
                cnt++;
                continue;
            }
            if(pq.peek()<nums[i])
            {
                pq.poll();
                pq.add(nums[i]);
            }

        }
        return pq.poll();

    }
}