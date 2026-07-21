package LeetCode.LinkedList;

/**
 * Platform: LeetCode
 * Problem ID: 92
 * Problem Name: Reverse LinkedList 2
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/reverse-linkedlist-2/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0092_ReverseLinkedlist2 {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0092_ReverseLinkedlist2...");
    }

    // TODO: Write solution method here
}
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftHead = head;
        ListNode prevLeft = null;
        int count = 0;
        while(count < left - 1 && leftHead!=null)
        {
            prevLeft = leftHead;
            leftHead = leftHead.next;
            count++;
        }



        ListNode rightHead = findNode(head, right);
        ListNode rightNext = rightHead.next;


        ListNode prev = null;
        ListNode nextNode = null;
        ListNode curr = leftHead;

        while(curr!=rightNext)
        {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        if(prevLeft!=null)
            prevLeft.next = prev;

        leftHead.next = rightNext;

        return head==leftHead?rightHead:head;


    }
    ListNode findNode(ListNode head, int k)
    {
        ListNode temp = head;
        int count = 0;
        while(count < k - 1 && temp!=null)
        {
            temp = temp.next;
            count++;
        }
        return temp;
    }
}