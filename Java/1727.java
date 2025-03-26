class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for (int i=0;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (matrix[j][i]!=0)
                    matrix[j][i] = matrix[j][i] + matrix[j-1][i];
            }
        }
        int ans=0;
        for (int i=0;i<n;i++) {
            TreeMap<Integer, Integer> mp = new TreeMap<>();
            for (int j=0;j<m;j++) {
                if (!mp.containsKey(matrix[i][j])) {
                    mp.put(matrix[i][j], 0);
                }
                mp.put(matrix[i][j], mp.get(matrix[i][j])+1);
            }
            List<Integer> c = new ArrayList<>(mp.values());
            for(int k=c.size()-2;k>=0;k--) {
                c.set(k, c.get(k+1) + c.get(k));
            }
            int l = 0;
            for (Map.Entry<Integer, Integer> entry: mp.entrySet()) {
                ans = Math.max(ans, entry.getKey() * c.get(l));
                l++;
            }

        }
        return ans;
    }
}

class Solution1 {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] != 0 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }

            int[] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, currRow[i] * (n - i));
            }
        }

        return ans;
    }
}