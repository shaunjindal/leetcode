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
    List<Integer> l;
    private void inorder(TreeNode t, boolean ins) {
        if (t==null) {
            return;
        }
        inorder(t.left, ins);
        if (ins) {
            int idx = Collections.binarySearch(l, t.val);
            if (idx >= 0) {
                l.add(idx, t.val);
            } else {
                int idxNew = Math.abs(idx) - 1;
                if (idxNew >= l.size()) {
                    l.add(t.val);
                } else {
                    l.add(idxNew, t.val);
                }
            }
        } else {
            l.add(t.val);
        }
        inorder(t.right, ins);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        l = new ArrayList<>();
        inorder(root1, false);
        inorder(root2, true);
//        getAllElements2(root1, root2);
        return l;
    }
}