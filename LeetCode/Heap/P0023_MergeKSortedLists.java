/**
 * Platform: LeetCode
 * Problem ID: 23
 * Problem Name: Merge k Sorted Lists
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Complexity:
 * - Time Complexity: O(nlogK)
 * - Space Complexity: O(k)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0023_MergeKSortedLists {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0023_MergeKSortedLists...");
    }

    // TODO: Write solution method here
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(int i = 0;i < lists.length;i++)
        {
            if(lists[i]!=null)
            {
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty())
        {
            ListNode curr = pq.poll();
            temp.next = curr;
            temp = temp.next;


            if(curr.next!=null)
            {
                pq.add(curr.next);
            }
        }

        return dummy.next;

    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        if(l1.val<=l2.val)
        {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = merge(l1, l2.next);
            return l2;
        }

    }
    public ListNode partitionMerge(ListNode[] lists,int s, int e){
        if(s>e)
        {
            return null;
        }
        if(s==e)
        {
            return lists[s];
        }

        int mid = s + (e-s)/2;

        ListNode L1 = partitionMerge(lists, s, mid);
        ListNode L2 = partitionMerge(lists, mid+1, e);

        return merge(L1, L2);
    }
    public ListNode mergeKLists(ListNode[] lists) {


        return partitionMerge(lists, 0, lists.length-1);





    }
}