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
    public ListNode removeNodes(ListNode head) {
        ListNode curr = head.next;
        Stack<ListNode> st = new Stack<>();
        st.add(head);
        while (curr != null) {
            if (!st.isEmpty() && curr.val <= st.peek().val) {
                st.add(curr);
            } else if(!st.empty() && st.peek().val < curr.val) {
                while (!st.empty() && st.peek().val < curr.val) {
                    st.pop();
                }
                if (!st.empty()) {
                    ListNode a = st.peek();
                    a.next = curr;
                } else {
                    head = curr;
                }
                st.add(curr);
            }
            curr=curr.next;
        }
        return head;
    }
}