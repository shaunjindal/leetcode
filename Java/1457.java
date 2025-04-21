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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[9];
        helper(root, freq);
        return ans;
    }
    int ans = 0;
    public void helper(TreeNode r, int[] freq) {
        if (r!=null) {
            freq[r.val-1]++;
            if (r.left==null && r.right==null && checkPal(freq)) ans++;
            helper(r.left, freq);
            helper(r.right, freq);
            freq[r.val-1]--;
        }
    }

    private boolean checkPal(int[] freq) {
        int c = 0;
        for (int i:freq) {
            if (i%2 == 1) {
                c++;
            }
        }
        return c==1 || c==0;
    }
}
