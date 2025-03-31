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

    public TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer, Integer> mp = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int l = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            int sum = 0;
            for (int i=0;i<sz;i++) {
                TreeNode t =  q.poll();
                sum+=t.val;
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
            mp.put(l++, sum);
        }
        l = 0;
        q.add(root);
        root.val = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i=0;i<sz;i++) {
                TreeNode t =  q.poll();
                if (t.right!=null && t.left!=null) {
                    int v = mp.getOrDefault(l+1, 0) - t.left.val - t.right.val;
                    t.right.val = v;
                    t.left.val = v;
                }
                if (t.right != null) {
                    q.add(t.right);
                }
                if (t.left!=null) {
                    q.add(t.left);
                }
                if (t.left==null && t.right!=null) {
                    t.right.val = mp.getOrDefault(l+1, 0) - t.right.val;
                }
                if (t.right==null && t.left!=null) {
                    t.left.val = mp.getOrDefault(l+1, 0) - t.left.val;
                }
            }
            l++;
        }
        return root;
    }
}