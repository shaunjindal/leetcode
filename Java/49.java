class Solution {
    private String genKey(int[] count) {
        StringBuilder s =  new StringBuilder();
        for (int i: count) {
            s.append(i).append("_");
        }
        return s.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int i=0;
        Map<String, List<String>> mp = new HashMap<>();
        for (String st: strs) {
            int[] count = new int[26];
            for (i=0;i<st.length();i++) {
                count[st.charAt(i)-'a']+=1;
            }
            String keyGen = genKey(count);
            if (!mp.containsKey(keyGen)) {
                mp.put(keyGen, new ArrayList<>());
            }
            mp.get(keyGen).add(st);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> ent: mp.entrySet()) {
            ans.add(ent.getValue());
        }
        return ans;
    }
}
