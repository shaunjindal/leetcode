class Solution {
    ArrayList<int[]>[] graph;
    List<Integer> ans = new ArrayList<>();
    String target;
    String start;
    boolean[] vis;
    boolean[] flipped;
    private boolean match(int i) {
        return (start.charAt(i) != target.charAt(i) && !flipped[i]) || (start.charAt(i) == target.charAt(i) && flipped[i]);
    }
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        graph = new ArrayList[n];
        vis = new boolean[n];
        this.target = target;
        this.start = start;
        this.flipped = new boolean[n];
        for (int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0;i<n-1;i++) {
            graph[edges[i][0]].add(new int[] {edges[i][1], i});
            graph[edges[i][1]].add(new int[] {edges[i][0], i});
        }
        dfs(0, -1, -1);
        Collections.sort(ans);
        return  match(0) ? Arrays.asList(-1) : ans;
    }

    private void dfs(int src, int par, int idx) {
        vis[src] = true;
        for (int[] adj: graph[src]) {
            if (!vis[adj[0]]) {
                dfs(adj[0], src, adj[1]);
            }
        }
        if (match(src) && idx != -1) {
            flipped[src] = !flipped[src];
            flipped[par] = !flipped[par];
            ans.add(idx);
        }
    }
}
