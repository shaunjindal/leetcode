class Solution {
    Map<Character, String> mp;
    public List<String> letterCombinations(String digits) {
        mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        List<String> st = new ArrayList<>();
        String curr = "";
        solve(digits, 0, st, curr);
        return st;
    }

    private void solve(String digits, int i, List<String> st, String curr) {
        if (i == digits.length()) {
            st.add(curr);
            return;
        }
        for (char c: mp.get(digits.charAt(i)).toCharArray()) {
            solve(digits, i + 1, st, curr + c); 
        }
    }
}
