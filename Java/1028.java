/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Node {
        TreeNode node;
        int depth;
        Node(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }
    public TreeNode recoverFromPreorder(String traversal) {
//        1-2--3--4-5--6--7
        int i = 0;
        StringBuilder s = new StringBuilder();
        while (i<traversal.length() && traversal.charAt(i) != '-') {
            s.append(traversal.charAt(i));
            i++;
        }
        Stack<Node> st = new Stack<>();
        st.add(new Node(0, new TreeNode(Integer.parseInt(s.toString()))));
        int d = 0;
        while (i<traversal.length()) {
            d = 0;
            s = new StringBuilder();
            while (i<traversal.length() && traversal.charAt(i) == '-') {
                d++;
                i++;
            }
            while (i<traversal.length() && traversal.charAt(i) != '-') {
                s.append(traversal.charAt(i));
                i++;
            }
            Node curr = st.peek();
            if (d - 1 == curr.depth) {
                Node n = new Node(d, new TreeNode(Integer.parseInt(s.toString())));
                if (curr.node.left == null) {
                    curr.node.left = n.node;
                } else {
                    curr.node.right = n.node;
                }
                st.add(n);
            } else {
                while (st.size() > 1 && st.peek().depth != d - 1) {
                    st.pop();
                }
                Node n = new Node(d, new TreeNode(Integer.parseInt(s.toString())));
                curr = st.peek();
                if (curr.node.left == null) {
                    curr.node.left = n.node;
                } else {
                    curr.node.right = n.node;
                }
                st.add(n);
            }
        }
        return st.firstElement().node;
    }
}
