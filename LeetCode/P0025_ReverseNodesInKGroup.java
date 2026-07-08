/**
 * Platform: LeetCode
 * Problem ID: 25
 * Problem Name: Reverse Nodes in k-Group
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0025_ReverseNodesInKGroup {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0025_ReverseNodesInKGroup...");
    }

    // TODO: Write solution method here
}
//Recursive Approach --> O(N), SC - O(N)

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextNode = null;

        int count = 0;
        while(curr!=null && count < k)
        {
            curr = curr.next;
            count++;
        }
        if(count < k)
            return head;

        count = 0;
        curr = head;

        while(curr!=null && count < k)
        {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            count++;
        }

        if(nextNode!=null)
        {
            ListNode restHead = reverseKGroup(nextNode, k);
            head.next = restHead;

        }
        return prev;
    }
}

//Approach 2: Iterative ---> O(N), SC - O(1)