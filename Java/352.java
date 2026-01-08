 class SummaryRanges {

        Set<Integer> st = new TreeSet<>();
        public SummaryRanges() {

        }

        public void addNum(int value) {
            st.add(value);
        }

        public int[][] getIntervals() {
            if (st.isEmpty()) {
                return new int[0][2];
            }
            List<int[]> ls = new ArrayList<>();
            int l = -1, r = -1;
            for (int i: st) {
                if (l < 0) {
                    l = r = i;
                } else if (i == r + 1) {
                    r = i;
                } else {
                    ls.add(new int[] {l, r});
                    l = r = i;
                }
            }
            ls.add(new int[] {l, r});
            return ls.toArray(new int[0][]);
        }
    }
