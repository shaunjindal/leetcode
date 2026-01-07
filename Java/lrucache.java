class LRUCache {

        class Node {
            int val;
            int key;
            Node forward;
            Node backward;
            public Node(int val, int key) {
                this.val = val;
                this.key = key;
            }
            public Node(int val, int key, Node forward, Node backward) {
                this(val, key);
                this.forward = forward;
                this.backward = backward;
            }
        }

        Node head;
        Node tail;
        int size;
        Map<Integer, Node> mp = new HashMap<>();
        int capacity;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.tail = new Node(-1, -1);
            this.head = new Node(-1, -1);
            tail.backward = head;
            head.forward = tail;
        }
        public int get(int key) {
            if (mp.containsKey(key)) {
                remove(mp.get(key));
                add(mp.get(key));
                return mp.get(key).val;
            }
            return -1;
        }

        void remove(Node node) {
            node.backward.forward = node.forward;
            node.forward.backward = node.backward;
        }

        void add(Node node) {
            node.forward = head.forward;
            node.forward.backward = node;
            head.forward = node;
            node.backward = head;
        }

        public void put(int key, int value) {
            if (mp.containsKey(key)) {
                remove(mp.get(key));
                mp.get(key).val = value;
                add(mp.get(key));
            } else {
                if (size == capacity) {
                    if (tail.backward.key != -1) {
                        mp.remove(tail.backward.key);
                        remove(tail.backward);
                    }
                    size--;
                }
                size++;
                Node toAdd = new Node(value, key);
                mp.put(key, toAdd);
                add(toAdd);
            }

        }
    }
