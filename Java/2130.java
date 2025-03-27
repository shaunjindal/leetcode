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
    private ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, next;

        // Traverse all the nodes of Linked List
        while (curr != null) {

            // Store next
            next = curr.next;

            // Reverse current node's next pointer
            curr.next = prev;

            // Move pointers one position ahead
            prev = curr;
            curr = next;
        }

        // Return the head of reversed linked list
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int n = 0;
        while(fast!=null && fast.next!=null) {
            n++;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode rev = reverse(slow);
        slow=head;
        int ans = 0;
        for (int i=0;i<n;i++) {
            ans = Math.max(ans, slow.val + rev.val);
            slow=slow.next;
            rev=rev.next;
        }
        return ans;
    }
}