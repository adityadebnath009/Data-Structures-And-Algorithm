package LeetCode.LinkedList;

/**
 * Platform: LeetCode
 * Problem ID: 19
 * Problem Name: Remove Nth node from a LinkedList
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/remove-nth-node-from-a-linkedlist/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0019_RemoveNthNodeFromALinkedlist {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0019_RemoveNthNodeFromALinkedlist...");
    }

    // TODO: Write solution method here
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while(i < n && fast!=null)
        {
            fast = fast.next;
            i++;
        }

        if(fast==null)
        {
            return head.next;
        }
        while(fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;


    }
}

