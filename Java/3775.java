class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        if (arr.length == 1) {
            return s;
        }
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        char[] first = arr[0].toCharArray();
        int count = 0;
        for (char c: first) {
            if (vowels.contains(c)) {
                count++;
            }
        }
        StringBuilder sB = new StringBuilder(arr[0]);
        for (int i=1;i<arr.length;i++) {
            sB.append(" ");
            first = arr[i].toCharArray();
            int ct = 0;
            for (char c: first) {
                if (vowels.contains(c)) {
                    ct++;
                }
            }
            if (ct == count) {
                sB.append(new StringBuilder(arr[i]).reverse());
            } else {
                sB.append(arr[i]);
            }
        }
        return sB.toString();
    }
}
