/**
 * Platform: LeetCode
 * Problem ID: 632
 * Problem Name: 632. Smallest Range Covering Elements from K Lists
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/632.-smallest-range-covering-elements-from-k-lists/
 * 
 * Complexity:
 * - Time Complexity: O(nlogk)
 * - Space Complexity: O(k)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0632_632SmallestRangeCoveringElementsFromKLists {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0632_632SmallestRangeCoveringElementsFromKLists...");
    }

    // TODO: Write solution method here
}

class Solution {
    class Pair{
        int listInd;
        int valInd;
        Pair(int listInd, int valInd)
        {
            this.listInd = listInd;
            this.valInd = valInd;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();

        int smallestRange[] = new int[2];
        smallestRange[0] = 0;
        smallestRange[1] = Integer.MAX_VALUE;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> nums.get(a.listInd).get(a.valInd) - nums.get(b.listInd).get(b.valInd));

        int maxCurr = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++)
        {
            pq.add(new Pair(i, 0));
            maxCurr = Math.max(maxCurr, nums.get(i).get(0));
        }

        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int listInd = p.listInd;
            int valInd = p.valInd;

            int minCurr = nums.get(listInd).get(valInd);

            if(maxCurr - minCurr < smallestRange[1] - smallestRange[0])
            {
                smallestRange[0] =  minCurr;
                smallestRange[1] = maxCurr;

            }

            if(valInd + 1 < nums.get(listInd).size())
            {
                pq.add(new Pair(listInd, valInd + 1));
                maxCurr = Math.max(maxCurr,  nums.get(listInd).get(valInd + 1));

            }
            else
            {
                break;
            }
        }
        return smallestRange;

    }
}