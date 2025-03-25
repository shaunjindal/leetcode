class Solution {
    public String sortVowels(String s) {
        Set<Character> st = new HashSet<>(Arrays.asList('a', 'e','i','o','u','A','E','I','O','U'));
        List<Character> ls = new ArrayList<>();
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if (st.contains(ch)) {
                ls.add(ch);
            }
        }
        if (ls.isEmpty()) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        ls.sort(Comparator.naturalOrder());
        int x = 0;
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if (st.contains(ch)) {
                ans.append(ls.get(x++));
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}