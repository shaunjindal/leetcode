class AllOne {
        class Pair {
            Node head;
            Node tail;
            int size;
            Pair() {
                head = new Node(-1, "");
                tail = new Node(-1, "");
                head.next = tail;
                tail.prev = head;
            }
        }
        class Node {
            int freq;
            Node next;
            Node prev;
            String key;
            Node(int freq, String key) {
                this.freq = freq;
                this.key = key;
            }
        }
        Map<String, Node> mp = new HashMap<>();
        TreeMap<Integer, Pair> freqMp = new TreeMap<>();
        public AllOne() {
        }

        public void inc(String key) {
            Node node;
            if (mp.containsKey(key)) {
                node = mp.get(key);
                remove(node);
                node.freq+=1;
            } else {
                node = new Node(1, key);
                mp.put(key, node);
            }
            add(node);
        }
        void remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            Pair curr = freqMp.get(node.freq);
            curr.size--;
            if (curr.size == 0) {
                freqMp.remove(node.freq);
            }
        }
        void add(Node node) {
            if (!freqMp.containsKey(node.freq)) freqMp.put(node.freq, new Pair());
            Pair curr = freqMp.get(node.freq);
            curr.size++;
            node.next = curr.head.next;
            curr.head.next.prev = node;
            curr.head.next = node;
            node.prev = curr.head;
        }

        public void dec(String key) {
            Node node = mp.get(key);
            remove(node);
            node.freq-=1;
            if (node.freq > 0)
                add(node);
            else mp.remove(key);
        }

        public String getMaxKey() {
            Integer maxKey = freqMp.lowerKey(Integer.MAX_VALUE);
            if (maxKey == null) return "";
            return freqMp.get(maxKey).head.next.key;
        }

        public String getMinKey() {
            Integer maxKey = freqMp.higherKey(Integer.MIN_VALUE);
            if (maxKey == null) return "";
            return freqMp.get(maxKey).head.next.key;
        }
    }
