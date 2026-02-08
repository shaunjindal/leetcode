class Solution {
    public int totalNQueens(int n) {
        List<StringBuilder> curr = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(".");
            }
            curr.add(s);
        }
        return solveNQ(curr, 0);
    }

    private int solveNQ(List<StringBuilder> curr, int r) {
        if (r == curr.size()) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i< curr.size(); i++) {
            if (validNq(r, i, curr, new int[]{-1, 0}) && validNq(r, i, curr, new int[]{-1,-1}) && validNq(r, i, curr, new int[]{-1, 1})) {
                StringBuilder row = curr.get(r);
                row.setCharAt(i, 'Q');
                ans = ans + solveNQ(curr, r + 1);
                row.setCharAt(i, '.');
            }
        }
        return ans;
    }

    private boolean validNq(int r, int c, List<StringBuilder> board, int[] dir) {
        int i = r + dir[0];
        int j = c + dir[1];
        while (i >= 0 && i < board.size() && j>=0 && j<board.size()) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
            i = i + dir[0];
            j = j + dir[1];
        }
        return true;
    }
}
