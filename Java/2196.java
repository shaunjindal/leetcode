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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> st=new HashMap<>();
        Set<Integer> par = new HashSet<>();
        int ans = -1;
        for(int[] curr: descriptions) {
            par.add(curr[1]);
            if (!st.containsKey(curr[0])) {
                TreeNode t = new TreeNode(curr[0]);
                TreeNode child;
                if (st.containsKey(curr[1])){
                    child = st.get(curr[1]);
                } else {
                    child = new TreeNode(curr[1]);
                    st.put(curr[1], child);
                }
                if (curr[2] == 1) {
                    t.left = child;
                } else {
                    t.right = child;
                }
                st.put(curr[0], t);
            } else {
                TreeNode t = st.get(curr[0]);
                TreeNode child;
                if (st.containsKey(curr[1])){
                    child = st.get(curr[1]);
                } else {
                    child = new TreeNode(curr[1]);
                    st.put(curr[1], child);
                }
                if (curr[2] == 1) {
                    t.left = child;
                } else {
                    t.right = child;
                }
            }

        }
        for (int[] i: descriptions) {
            if (!par.contains(i[0])) {
                return st.get(i[0]);
            }
        }
        return null;
    }
}