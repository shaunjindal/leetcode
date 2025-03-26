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
    int totSum = 0;
    private void process(TreeNode curr) {
        if (curr == null) {
            return;
        }
        process(curr.right);
        totSum = totSum + curr.val;
        curr.val = totSum;
        process(curr.left);
    }
    public TreeNode convertBST(TreeNode root) {
        process(root);
        return root;
    }

}