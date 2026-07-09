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

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        ListNode nextNode = null;
        ListNode prev = null;
        ListNode prevFirst = null;
        int count = 0;

        boolean isFirstPass = true;

        while(curr!=null)
        {
            count = 0;
            ListNode first = curr;
            ListNode temp = curr;
            prev = null;
            while(temp!=null && count < k)
            {
                temp = temp.next;
                count++;
            }
            if(count < k && prevFirst!=null)
            {
                prevFirst.next = curr;
                break;
            }
            count = 0;

            while(curr!=null && count<k)
            {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                count++;

            }
            if(isFirstPass)
            {
                head = prev;
                isFirstPass = false;
            }
            else
            {
                prevFirst.next = prev;

            }
            prevFirst = first;

        }
        return head;
    }

}