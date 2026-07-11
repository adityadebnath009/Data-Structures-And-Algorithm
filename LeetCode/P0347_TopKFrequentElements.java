/**
 * Platform: LeetCode
 * Problem ID: 347
 * Problem Name: Top K frequent Elements
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * Complexity:
 * - Time Complexity: O(N + mlogk)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0347_TopKFrequentElements {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0347_TopKFrequentElements...");
    }

    // TODO: Write solution method here
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Min-Heap

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length;i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int size = map.size();
        int j = 0;
        int pair[][] = new int[size][2];
        for(int key: map.keySet())
        {
            pair[j][0] = key;
            pair[j][1] = map.get(key);
            j++;
        }
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);

        for(int i = 0;i < size;i++)
        {
            pq.add(pair[i]);

            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        int ans[] = new int[pq.size()];
        j = 0;

        while(!pq.isEmpty())
        {
            ans[j++] = pq.poll()[0];

        }
        return ans;

    }
}