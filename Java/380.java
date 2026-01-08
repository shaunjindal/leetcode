class RandomizedSet {
        int c = 0;
        Set<Integer> st = new HashSet<>();
        public RandomizedSet() {

        }

        public boolean insert(int val) {
            return st.add(val);
        }

        public boolean remove(int val) {
            return st.remove(val);
        }

        public int getRandom() {
            int floor = (int) Math.floor(Math.random() * st.size());
            return (int) st.toArray()[floor];
        }
    }
