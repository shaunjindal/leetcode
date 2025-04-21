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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast=head, prev=null;
        int i=0;
        while (i<k-1 && slow!=null) {
            slow=slow.next;
            i++;
        }
        ListNode fs = slow;
        while (slow!=null) {
            slow=slow.next;
            prev=fast;
            fast=fast.next;
        }
        if (fs!=null && prev!=null) {
            int temp = fs.val;
            fs.val = prev.val;
            prev.val = temp;
        }
        return head;
    }
}
