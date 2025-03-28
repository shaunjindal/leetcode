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
    private void processTree(TreeNode root, int target, TreeNode par) {
        if (root == null) {
            return;
        }
        processTree(root.left, target, root);
        processTree(root.right, target, root);
        if (root.left==null && root.right == null && root.val == target) {
            if (par.left == root) {
                par.left = null;
            } else {
                par.right = null;
            }
        }


    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // 2
        //     2
        //    2    2
        //  8   10    2
        //    2

        processTree(root, target, root);
        if (root!=null && root.val == target && root.right==null && root.left==null) {
            return null;
        }
        return root;
    }
}