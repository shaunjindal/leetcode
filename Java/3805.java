class Solution {
    public long countPairs(String[] words) {
        Map<String, Integer> mp = new HashMap<>();
        long ans = 0;
        for (int i=0;i<words.length;i++) {
            String s = convert(words[i]);
            if (mp.containsKey(s)) {
                ans = ans + mp.get(s);
            }
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }
        return ans;
    }

    String convert(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int a = -1;
        for (char cc: c) {
            if (a==-1) {
                a = cc-'a';
            }
            sb.append((char)((26+cc - a)%26));
        }
        return sb.toString();
    }
}
