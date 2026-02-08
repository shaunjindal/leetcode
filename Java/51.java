class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<StringBuilder> curr = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(".");
            }
            curr.add(s);
        }
        StringBuilder s = new StringBuilder();
        List<List<String>> ans = new ArrayList<>();
        solveNQ(ans, curr, 0);
        return ans;
    }

    private void solveNQ(List<List<String>> ans, List<StringBuilder> curr, int r) {
        if (r == curr.size()) {
            List<String> s = new ArrayList<>();
            for (StringBuilder sb: curr) {
                s.add(sb.toString());
            }
            ans.add(s);
            return;
        }
        for (int i = 0; i< curr.size(); i++) {
            if (validNq(r, i, curr, new int[]{-1, 0}) && validNq(r, i, curr, new int[]{-1,-1}) && validNq(r, i, curr, new int[]{-1, 1})) {
                StringBuilder row = curr.get(r);
                row.setCharAt(i, 'Q');
                solveNQ(ans, curr, r + 1);
                row.setCharAt(i, '.');
            }
        }
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
