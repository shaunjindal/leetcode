class Solution {
    List<String> curr = new ArrayList<>();
    char[] letters;
    int[] score;
    String[] words;
    int ans;
    int[] count;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.letters = letters;
        this.score = score;
        this.curr = new ArrayList<>();
        this.ans = 0;
        this.count = new int[26];
        for (char c: letters) {
            count[c-'a']++;
        }
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int currSet) {
        if (i == words.length) {
            ans = Math.max(ans, currSet);
            return;
        }
        int currScore = 0;
        String currWord = words[i];
        int[] set = new int[26];
        for (int j = 0; j < currWord.length(); j++) {
            if (count[currWord.charAt(j) - 'a'] - 1 >= 0) {
                count[currWord.charAt(j) - 'a']-=1;
                set[currWord.charAt(j) - 'a']++;
                currScore = currScore + score[currWord.charAt(j) - 'a'];
            } else {
                currScore = 0;
                break;
            }
        }
        curr.add(words[i]);
        dfs(i+1, currScore + currSet);
        for (int j = 0; j < set.length; j++) {
            count[j]+=set[j];
        }
        curr.remove(curr.size() - 1);
        dfs(i+1, currSet);
    }
}
