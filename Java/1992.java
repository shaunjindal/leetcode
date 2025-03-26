class Solution {
    public int[][] findFarmland(int[][] land) {
        int n=land.length;
        int m=land[0].length;
        int[][] dir = {{1,0},{0,1}};
        List<int[]> ans = new ArrayList<>();
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if(land[i][j] == 1) {
                    if ((i-1 >=0 && land[i-1][j] == 0 && j-1 >=0 && land[i][j-1] == 0) || (i==0 && j==0) || (i==0 && j>0 && land[i][j-1]==0) || (j==0 && i-1>=0 && land[i-1][j]==0)) {
                        int k=i;
                        int l=j;
                        while(k<n && land[k][j] == 1) {
                            k++;
                        }
                        while(l<m && land[i][l] == 1) {
                            l++;
                        }
                        ans.add(new int[]{i, j, k - 1, l - 1});
                    }

                }
            }
        }
        int[][] ansF = new int[ans.size()][4];
        for (int i=0;i<ans.size();i++) {
            ansF[i] = ans.get(i);
        }
        return ansF;
    }
}
