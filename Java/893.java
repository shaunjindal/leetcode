class Solution {
    private String processString(String s){
        int len = s.length();

        char[] s1 = new char[(len+1)/2];
        char[] s2 = new char[len/2];
        for (int i=0;i<s.length();i++) {
            if (i%2==0) {
                s1[i/2] = s.charAt(i);
            } else {
                s2[i/2] = s.charAt(i);
            }
        }
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.toString(s1)+Arrays.toString(s2);
    }

    public int numSpecialEquivGroups(String[] words) {
        int n = words.length;
        Set<String> mp = new HashSet<>();
        for (int i=0;i<n;i++) {
            mp.add(processString(words[i]));
        }
        return mp.size();
    }
}