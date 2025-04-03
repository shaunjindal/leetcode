/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> curr = new ArrayList<>();
            while (sz>0) {
                Node f = q.poll();
                curr.add(f.val);
                for (Node n: f.children) {
                    q.add(n);
                }
                sz--;
            }
            ans.add(curr);
        }
        return ans;
    }
}