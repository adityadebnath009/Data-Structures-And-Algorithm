/**
 * Platform: LeetCode
 * Problem ID: 378
 * Problem Name: Kth Smallest Element in a Sorted Matrix
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0378_KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0378_KthSmallestElementInASortedMatrix...");
    }

    // TODO: Write solution method here
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int ans = 0;

        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int cnt = count(mid, matrix);
            if(cnt < k)
            {
                low = mid + 1;
            }
            else
            {
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;

    }
    int count(int num, int matrix[][])
    {
        int n = matrix.length;
        int cnt = 0;
        for(int i = 0;i < n;i++)
        {

            for(int j = 0;j < n;j++)
            {
                if(matrix[i][j] <= num)
                {
                    cnt++;

                }

            }

        }
        return cnt;
    }
}