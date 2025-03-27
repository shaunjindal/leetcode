class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Queue<List<Integer>> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        t.add(0);
        q.add(t);
        while (!q.isEmpty()) {
            List<Integer> curr = q.poll();
            int last = curr.get(curr.size()-1);
            if (last == graph.length-1) {
                ans.add(new ArrayList<>(curr));
            } else {
                for (int i=0;i<graph[last].length;i++) {
                    List<Integer> temp = new ArrayList<>(curr);
                    temp.add(graph[last][i]);
                    q.add(temp);
                }
            }
        }
        return ans;
    }
}