class LRUCache {

    private static class Node{
        Node next;
        Node prev;
        int val, key;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private int cap;
    private Map<Integer, Node> map;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();

        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = right;
        this.right.prev = left;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            remove(temp);
            insert(temp);
            return temp.val;
        } else
            return -1;
        
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        else if(cap == map.size()){
            map.remove(left.next.key);
            remove(left.next);
        }

        Node temp =  new Node(key, value);
        insert(temp);
        map.put(key, temp);
    }

    private void insert(Node node) {
        node.next = right;
        node.prev = right.prev;
        right.prev.next = node;
        right.prev = node;

    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
