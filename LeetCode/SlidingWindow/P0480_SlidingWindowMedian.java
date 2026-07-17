package LeetCode.Array;

/**
 * Platform: LeetCode
 * Problem ID: 480
 * Problem Name: Sliding Window Median
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/sliding-window-median/
 * 
 * Complexity:
 * - Time Complexity: O(nlogK)
 * - Space Complexity: O(k)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0480_SlidingWindowMedian {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0480_SlidingWindowMedian...");
    }

    // TODO: Write solution method here
}
//I spent three hours solving this problem. The first intuition is that if you have solved the “find the median in a data stream” problem, you already understand the key logic I am using here: maxHeap and minHeap, and what they do.

//The main idea is that the same steps are performed for each sliding window. We move the window, remove the element that falls outside, and add the new element that enters. This is the standard approach for sliding‑window problems. We will apply the same “find a median in a stream” logic here. Out of 45 cases, only 44 will pass; the last one results in TLE

//We use a hashMap for lazy deletion which means we do not remove an element directly from the heap because that would cost O(n). Instead, we mark the element in a map as deleted. We do not delete it; we simply flag it. Whenever we need to perform a heap operation, we first prune any elements marked as deleted.

//If you look closely, there are many cases in the add, remove, and balance functions. The deleted element may appear at the top of the heap. When it reaches the top, we can prune it, allowing removal in O(log n) time. That is the logic we are using.


class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int leftSize = 0;
    int rightSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int idx = 0;

        List<Double> ans = new ArrayList<>();

        while (j < nums.length) {

            add(nums[j]);

            if (j - i + 1 == k) {

                ans.add(getMedian());
                remove(nums[i]);
                i++;

            }
            j++;
        }
        double res[] = new double[ans.size()];
        for (double num : ans) {
            res[idx++] = num;
        }
        return res;

    }

    double getMedian() {

        prune(maxHeap);
        prune(minHeap);

        if (leftSize == rightSize) {
            return ((long) maxHeap.peek() + (long) minHeap.peek()) / 2.0;
        }

        return (double) maxHeap.peek();
    }

    void add(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
            leftSize++;
        } else {
            minHeap.add(num);
            rightSize++;
        }

        balance();
        prune(maxHeap);
        prune(minHeap);

    }

    void remove(int num) {

        map.put(num, map.getOrDefault(num, 0) + 1);

        if (num <= maxHeap.peek()) {
            leftSize--;

            if (num == maxHeap.peek()) {
                prune(maxHeap);
            }

        } else {

            rightSize--;

            if (!minHeap.isEmpty() && num == minHeap.peek()) {
                prune(minHeap);
            }
        }

        balance();
    }

    void prune(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty()) {
            int x = pq.peek();
            if (!map.containsKey(x)) {
                return;
            }
            pq.poll();
            map.put(x, map.get(x) - 1);
            if (map.get(x) == 0) {
                map.remove(x);
            }
        }
    }

    void balance() {
        while (leftSize > rightSize + 1) {
            minHeap.add(maxHeap.poll());
            leftSize--;
            rightSize++;
            prune(maxHeap);
        }

        while (leftSize < rightSize) {
            maxHeap.add(minHeap.poll());
            leftSize++;
            rightSize--;
            prune(minHeap);
        }
    }
}