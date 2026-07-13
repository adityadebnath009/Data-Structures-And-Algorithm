/**
 * Platform: LeetCode
 * Problem ID: 373
 * Problem Name: Find K Pairs with Smallest Sums
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * 
 * Complexity:
 * - Time Complexity: O(klogk)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 *
 * Each row behaves like a sorted list.
 *
 * This is exactly the same idea as Merge K Sorted Lists (LC 23):
 *
 * Each row is a sorted list.
 * The heap stores the current smallest element from each row.
 * When one element is removed, insert the next element from the same row.
 *
 * That's why no visited set is needed.
 */

public class P0373_FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0373_FindKPairsWithSmallestSums...");
    }

    // TODO: Write solution method here
}
class Solution {
    class Pair{
        int x;
        int y;
        int sum;
        Pair(int x, int y, int sum)
        {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list  = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.sum - b.sum);
        Set<String> visited = new HashSet<>();

        pq.add(new Pair(0, 0, nums1[0] + nums2[0]));
        visited.add("0#0");


        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int i = p.x;
            int j = p.y;
            int sum = p.sum;

            if(list.size()==k)
            {
                return list;
            }

            list.add(Arrays.asList(nums1[i], nums2[j]));

            if(i + 1 < nums1.length && !visited.contains((i+1)+ "#" +j))
            {
                pq.add(new Pair(i+1, j, nums1[i+1] + nums2[j]));
                visited.add((i+1)+ "#" +j);
            }
            if(j + 1< nums2.length && !visited.contains(i + "#"+ (j+1)))
            {
                visited.add(i + "#"+ (j+1));
                pq.add(new Pair(i, j+1, nums1[i] + nums2[j+1]));
            }
        }

        return list;






    }
}

// Approach2 : Optimization(Without visited set)

class Solution {
    class Pair{
        int x;
        int y;
        int sum;
        Pair(int x, int y, int sum)
        {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k)
    {

        List<List<Integer>> list  = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.sum, b.sum));



        for(int i = 0;i < Math.min(nums1.length, k);i++)
        {
            pq.add(new Pair(i, 0, nums1[i] + nums2[0]));
        }

        while(k > 0 && !pq.isEmpty())
        {
            Pair p = pq.poll();
            int i = p.x;
            int j = p.y;

            list.add(Arrays.asList(nums1[i], nums2[j]));

            if(j + 1 < nums2.length)
            {
                pq.add(new Pair(i, j + 1, nums1[i] + nums2[j+1]));
            }
            k--;

        }

        return list;

    }
}
