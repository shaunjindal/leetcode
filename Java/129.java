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
     int ans = 0;
    private void helper(TreeNode root, int curr) {
        if (root == null) {
            return;
        }
        curr = curr*10 + root.val;
        helper(root.left, curr);
        helper(root.right, curr);
        if (root.right == null && root.left == null) {
            ans = ans + curr;
        }
        curr/=10;
    }
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return ans;
    }
}
