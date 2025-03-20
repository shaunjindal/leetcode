class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int startx;
        int starty;
        List<Integer> curr = new ArrayList<>();
        for (int i=1;i<n;i++) {
            starty=i;
            startx=0;
            while(starty<n && startx<n) {
                curr.add(grid[startx][starty]);
                starty = starty+1;
                startx=startx+1;
            }
            curr.sort(Comparator.naturalOrder());
            startx = 0;
            starty=i;
            for (Integer integer : curr) {
                grid[startx][starty] = integer;
                starty = starty+1;
                startx=startx+1;
            }
            curr.clear();
        }
        curr.clear();
        for (int i=0;i<n;i++) {
            starty=0;
            startx=i;
            while(starty<n && startx<n) {
                curr.add(grid[startx][starty]);
                starty = starty+1;
                startx=startx+1;
            }
            curr.sort(Comparator.reverseOrder());
            starty=0;
            startx=i;
            for (Integer integer : curr) {
                grid[startx][starty] = integer;
                starty = starty+1;
                startx=startx+1;
            }
            curr.clear();
        }
        return grid;
    }
}