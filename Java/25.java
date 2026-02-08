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
    int c = 0;
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode l = head;
        while (l != null) {
            l = l.next;
            c++;
        }
        return helper(head, k);
    }

    private ListNode helper(ListNode head, int k) {
        if (head == null || c - k < 0) {
            return head;
        }
        c = c - k;
        ListNode currHead = head, prev = null, temp = null;
        for (int i = 0; i < k; i++) {
            temp = currHead.next;
            currHead.next = prev;
            prev = currHead; 
            currHead = temp;
        }
        head.next = helper(currHead, k);
        return prev;
    }
}
