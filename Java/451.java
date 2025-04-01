class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            mp.putIfAbsent(s.charAt(i), 0);
            mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);
        }
        StringBuilder ans= new StringBuilder();
        mp.entrySet().stream().sorted(new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                })
                .forEach(c -> {
                    for (int i=0;i<c.getValue();i++) ans.append(c.getKey());
                });
        return ans.toString();
    }
}