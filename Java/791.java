class Solution {
    public String customSortString(String order, String s) {
        Comparator<Character> comparator = new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(order.indexOf(o1), order.indexOf(o2));
            }
        };
        Character[] mat = new Character[s.length()];
        for (int i=0;i<mat.length;i++) {
            mat[i]=s.charAt(i);
        }
        Arrays.sort(mat, comparator);
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<mat.length;i++) {
            ans.append(mat[i]);
        }
        return ans.toString();
    }
}