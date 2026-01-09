class Twitter {

    Map<Integer, LinkedList<Tweet>> tweets = new HashMap<>();
    Map<Integer, HashSet<Integer>> users = new HashMap<>();
    int counter = 0;
    class Tweet {
        int id;
        int stamp;
        Tweet next;
        Tweet(int id, int stamp) {
            this.id = id;
            this.stamp = stamp;
        }
    }
    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<>());
        }
        if (!users.containsKey(userId)) {
            users.put(userId, new HashSet<>());
        }
        Tweet newTweet = new Tweet(tweetId, counter++);
        if (!tweets.get(userId).isEmpty()) {
            newTweet.next = tweets.get(userId).getFirst();
        }
        tweets.get(userId).addFirst(newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        Comparator<Tweet> comparator = new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o2.stamp > o1.stamp ? 1 : -1;
            }
        };
        PriorityQueue<Tweet> pq = new PriorityQueue<>(comparator);
        if (users.containsKey(userId)) {
            users
                    .get(userId)
                    .forEach(u -> {
                        if (tweets.get(u) != null && !tweets.get(u).isEmpty()) {
                            pq.add(tweets.get(u).getFirst());
                        }
                    } );
        }
        if (tweets.containsKey(userId)) {
            pq.add(tweets.get(userId).getFirst());
        }
        int c = 10;
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty() && c>0) {
            c--;
            Tweet curr = pq.poll();
            if (curr.next != null) {
                pq.add(curr.next);
            }
            ans.add(curr.id);
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new HashSet<>());
        }
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new HashSet<>());
        }
        users.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new HashSet<>());
        }
        if (!users.containsKey(followeeId)) {
            users.put(followeeId, new HashSet<>());
        }
        users.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

