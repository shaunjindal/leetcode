class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i: arr) {
            mp.putIfAbsent(i, 0);
            mp.put(i, mp.get(i)+1);
        }

        List<Integer> ls = mp.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int ans = 0, c=0;
        for (int i: ls) {
            c = c + i;
            ans++;
            if (c>=((arr.length)/2)) {
                return ans;
            }

        }
        return ans;
    }
}
