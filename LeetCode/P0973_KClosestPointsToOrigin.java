/**
 * Platform: LeetCode
 * Problem ID: 973
 * Problem Name: K Closest Points to Origin
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/k-closest-points-to-origin/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0973_KClosestPointsToOrigin {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0973_KClosestPointsToOrigin...");
    }

    // TODO: Write solution method here
}

class Solution {
    class Pair{
        int x;
        int y;
        int dist;
        Pair(int x, int y, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    int distance(int x, int y)
    {
        return x*x + y*y;
    }
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.dist  - a.dist);

        for(int pair[]:points)
        {
            pq.add(new Pair(pair[0], pair[1], distance(pair[0], pair[1])));
            if(pq.size() > k)
            {
                pq.poll();
            }
        }

        int n = pq.size();
        int i = 0;
        int ans[][] = new int[n][2];
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }

        return ans;





    }
}