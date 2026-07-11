/**
 * Platform: LeetCode
 * Problem ID: 658
 * Problem Name: K closest numbers
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/k-closest-numbers/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0658_KClosestNumbers {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0658_KClosestNumbers...");
    }

    // TODO: Write solution method here
}
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {

//         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->{
//             int d1 = Math.abs(a - x);
//             int d2 = Math.abs(b - x);

//             if(d1==d2)
//             {
//                 return Integer.compare(b,a);
//             }
//             else
//             {
//                 return Integer.compare(d2, d1);
//             }
//         });

//         for(int i = 0;i < arr.length;i++)
//         {

//             pq.add(arr[i]);

//             if(pq.size() > k)
//             {
//                 pq.poll();
//             }
//         }

//         List<Integer> list = new ArrayList<>();

//         while(!pq.isEmpty())
//         {
//             list.add(pq.poll());
//         }
//         Collections.sort(list);

//         return list;

//     }
// }

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        int left = 0;
        int right = n - k;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (x - arr[mid] <= arr[mid + k] - x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = left; i < left + k; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}
/**
The key observation is that the array is already sorted,
which means the k closest elements to x will always form a contiguous subarray (window) of size k.
Instead of choosing individual elements, we only need to determine the best starting index of this window.
There are n - k + 1 possible windows, so we perform binary search on the starting indices from 0 to n - k.
At each step, we compare two adjacent candidate windows:
the current window starting at mid and the next window starting at mid + 1.
These two windows differ by only two elements—arr[mid] (which leaves the window) and arr[mid + k] (which enters the window).
If arr[mid] is farther from x than arr[mid + k], then shifting the window to the right gives a better answer, so we move left = mid + 1.
Otherwise, we keep the current window (or search further left) by setting right = mid. When the binary search ends, left points to the starting
index of the optimal window, and the answer is simply the k consecutive elements starting from that index.
This reduces the complexity from O(n) or O(n log k) to O(log(n - k) + k).

 **/

