class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> mp = new HashMap<>();
        for (String s: cpdomains) {
            String[] sp = s.split(" ");
            String[] sd = sp[1].split("\\.");
            int count = Integer.parseInt(sp[0]);
            if (sd.length == 3) {
                if (!mp.containsKey(sd[1]+ "." +sd[2])) {
                    mp.put(sd[1]+ "." + sd[2], 0);
                }
                mp.put(sd[1]+ "." +sd[2], mp.get(sd[1]+ "." +sd[2]) + count);
            }
            if (!mp.containsKey(sp[1])) {
                mp.put(sp[1], 0);
            }
            mp.put(sp[1], mp.get(sp[1]) + count);
            if (!mp.containsKey(sd[sd.length-1])) {
                mp.put(sd[sd.length-1], 0);
            }
            mp.put(sd[sd.length-1], mp.get(sd[sd.length-1]) + count);
        }
        return mp.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey()).collect(Collectors.toList());
    }
}