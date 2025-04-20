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
    
    Map<Integer, Integer> mp = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        Comparator<Map.Entry<Integer, Integer>> com = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        };
        List<Map.Entry<Integer, Integer>> ans = mp.entrySet().stream().sorted(com).collect(Collectors.toList());
        int i = 0;
        while (i<ans.size() && Objects.equals(ans.get(i).getValue(), ans.get(0).getValue())) {
            i++;
        }
        int[] f = new int[i];
        for (int j=0;j<i;j++) {
            f[j] = ans.get(j).getKey();
        }
        return f;
    }
    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int currTreeSum = root.val + helper(root.left) + helper(root.right);
        if (!mp.containsKey(currTreeSum)) {
            mp.put(currTreeSum, 0);
        }
        mp.put(currTreeSum, mp.get(currTreeSum) + 1);
        return currTreeSum;
    }
}
