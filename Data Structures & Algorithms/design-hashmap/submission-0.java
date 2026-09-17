class MyHashMap {
    class Node {
            int key;
            int value;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

    Node[] buckets;
    int size = 1000;
    public MyHashMap() {
        buckets = new Node[size];

    }
    
    public void put(int key, int value) {
        int index = key % size;

        Node current = buckets[index];

        // key already exists
        while (current != null) {

            if (current.key == key) {
                current.value = value;
                return;
            }

            current = current.next;
        }

        // insert new node at beginning
        Node newNode = new Node(key, value);

        newNode.next = buckets[index];
        buckets[index] = newNode;
    }
    
    public int get(int key) {
        int index = key % size;

        Node current = buckets[index];

        while (current != null) {

            if (current.key == key) {
                return current.value;
            }

            current = current.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = key % size;

        Node current = buckets[index];
        Node previous = null;

        while (current != null) {

            if (current.key == key) {

                if (previous == null) {
                    buckets[index] = current.next;
                } 
                else {
                    previous.next = current.next;
                }

                return;
            }

            previous = current;
            current = current.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */