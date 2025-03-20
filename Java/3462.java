class Solution {
    class Node {
        public int x;
        public int i;
        public int j;
        public Node(int x, int i, int j) {
            this.x = x;
            this.i = i;
            this.j = j;
        }
    }
    public long maxSum2(int[][] grid, int[] limits, int k) {
        int n = grid.length;
        int m = grid[0].length;
        long ans = 0;
        for(int[] curr:grid) {
            Arrays.sort(curr);
        }
        List<Integer> ls = new ArrayList<>();
        for (int i=0;i<n;i++) {
            int l=m-1;
            for (int j=0;j<limits[i];j++) {
                ls.add(grid[i][l--]);
            }
        }
        ls.sort(Comparator.naturalOrder());
        for (int i=ls.size() - 1;i>=0 && k>0;i--) {
            ans = ans+ls.get(i);
            k--;
        }
        return ans;
    }
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Comparator<Solution.Node> comparator = new Comparator<Solution.Node>() {
            @Override
            public int compare(Solution.Node o1, Solution.Node o2) {
                // Compare in reverse order to prioritize higher X values
                return Integer.compare(o2.x, o1.x);
            }
        };
        PriorityQueue<Solution.Node> pq = new PriorityQueue<>(comparator);
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                pq.add(new Node(grid[i][j],i,j));
            }
        }
        long ans = 0;
        for (int i=0; i<k && !pq.isEmpty();) {
            Solution.Node curr = pq.poll();
            if (limits[curr.i] > 0) {
                ans = ans + grid[curr.i][curr.j];
                limits[curr.i]--;
                i++;
            }
        }
        return ans;
    }
}