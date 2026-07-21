package LeetCode.LinkedList;

/**
 * Platform: LeetCode
 * Problem ID: 24
 * Problem Name: SwapNodesInPair
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/swapnodesinpair/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0024_Swapnodesinpair {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0024_Swapnodesinpair...");
    }

    // TODO: Write solution method here
}

// class Solution {
//     public ListNode swapPairs(ListNode head) {

//         if(head==null || head.next==null)
//         {
//             return head;
//         }
//         ListNode first = head;
//         ListNode second = head.next;


//         first.next = swapPairs(second.next);

//         second.next = first;

//         return second;

//     }
// }

class Solution {
    public ListNode swapPairs(ListNode head) {

        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode first = head;
        ListNode newHead = first.next;

        ListNode prev = null;

        while(first!=null && first.next!=null)
        {
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;

            if(prev!=null)
            {
                prev.next = second;
            }
            prev = first;
            first = first.next;
        }
        return newHead;
    }
}