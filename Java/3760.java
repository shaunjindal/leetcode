class Solution {
    public int maxDistinct(String s) {
        boolean[] b = new boolean[26];
        char[] c = s.toCharArray();
        for (char cc: c) {
            b[cc-'a'] = true;
        }
        return (int)java.util.stream.IntStream
                .range(0, b.length)
                .filter(i -> b[i])
                .count();
    }
}
