class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] ans = new char[boxGrid[0].length][boxGrid.length];
        int stones = 0, spaces = 0;
        for (int i = 0; i < boxGrid.length; i++) {
            char[] curr = new char[boxGrid[0].length];
            for (int j = 0; j < boxGrid[0].length; j++) {
                if (boxGrid[i][j] == '#') {
                    stones++;
                    curr[j] = '.';
                } else if (boxGrid[i][j] == '.') {
                    spaces++;
                    curr[j] = '.';
                } else {
                    if (stones > 0) {
                        for (int k = j - 1; stones > 0; stones--, k--) {
                            curr[k] = '#';
                        }
                    }
                    curr[j] = '*';
                    spaces = 0;
                    stones = 0;
                }
            }
            if (stones > 0) {
                for (int k = boxGrid[0].length - 1; stones > 0; stones--, k--) {
                    curr[k] = '#';
                }
            }
            for (int k = 0; k < boxGrid[0].length; k++) {
                ans[k][boxGrid.length - 1 - i] = curr[k];
            }
        }
        return ans;
    }
}