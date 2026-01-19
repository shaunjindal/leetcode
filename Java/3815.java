class AuctionSystem {

        Map<Integer, Map<Integer, Integer>> store = new HashMap<>();

        Map<Integer, TreeMap<Integer, TreeSet<Integer>>> store2 = new HashMap<>();

        public AuctionSystem() {

        }

        public void addBid(int userId, int itemId, int bidAmount) {
            if (store.containsKey(itemId)) {
                if (store.get(itemId).containsKey(userId)) {
                    int bid = store.get(itemId).get(userId);
                    store2.get(itemId).get(bid).remove(userId);
                    if (store2.get(itemId).get(bid).isEmpty()) store2.get(itemId).remove(bid);
                }
                store.get(itemId).put(userId, bidAmount);
                store2.get(itemId).computeIfAbsent(bidAmount, k -> new TreeSet<>());
                store2.get(itemId).get(bidAmount).add(userId);
            } else {
                store.put(itemId, new HashMap<>());
                store2.put(itemId, new TreeMap<>());
                addBid(userId, itemId, bidAmount);
            }
        }

        public void updateBid(int userId, int itemId, int newAmount) {
            removeBid(userId, itemId);
            addBid(userId, itemId, newAmount);
        }

        public void removeBid(int userId, int itemId) {
            int bid = store.get(itemId).get(userId);
            store.get(itemId).remove(userId);
            if (store.get(itemId).isEmpty()) store.remove(itemId);
            store2.get(itemId).get(bid).remove(userId);
            if (store2.get(itemId).get(bid).isEmpty()) store2.get(itemId).remove(bid);
            if (store2.get(itemId).isEmpty()) store2.remove(itemId);
        }

        public int getHighestBidder(int itemId) {
            if (store2.containsKey(itemId)) {
                TreeSet<Integer> s = store2.get(itemId).lastEntry().getValue();
                return s.isEmpty() ? -1 : s.last();
            }
            return -1;
        }
    }
    
