class Solution {
    List<Character> vowels = Arrays.asList('a','e','i','o','u');
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] pref = new int[words.length];
        if (vowels.contains(words[0].charAt(0)) && vowels.contains(words[0].charAt(words[0].length()-1))) {
            pref[0] = 1;
        }
        for (int i=1;i<pref.length;i++) {
            pref[i] = pref[i-1] + (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length()-1)) ? 1 : 0);
        }
        int[] ans = new int[queries.length];
        for (int i=0;i<queries.length;i++) {
            ans[i] = pref[queries[i][1]] - (queries[i][0] == 0 ? 0 : pref[queries[i][0] - 1]);
        }
        return ans;
    }
}
