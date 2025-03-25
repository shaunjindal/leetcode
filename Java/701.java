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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null) {
            prev = curr;
            if (curr.val < val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        TreeNode n = new TreeNode(val);
        if (prev==null) {
            return n;
        }
        if (prev.val < val) {
            prev.right = n;
        } else {
            prev.left = n;
        }
        return root;
    }
}