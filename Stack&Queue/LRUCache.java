class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer,Node> mp = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int c;

    public LRUCache(int capacity) {
         c = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            int value = mp.get(key).val;
            remove(key);
            insert(new Node(key,value));
            return value;
        }else
        return -1;
    }
    
    public void put(int key, int val) {
        if(mp.containsKey(key)){
            remove(key);
        }
        if(mp.size()==c){
             remove(tail.prev.key);
        }
        insert(new Node(key,val));
    }

    public void insert(Node node){
        mp.put(node.key,node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void remove(int ele){
        Node node = mp.get(ele);
        mp.remove(ele);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,val);
 */