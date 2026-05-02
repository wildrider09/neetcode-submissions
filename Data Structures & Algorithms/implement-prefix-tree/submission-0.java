class PrefixTree {

    class Trie{
        boolean isEnd;
        Trie []arr;

        public Trie(){
            isEnd = false;
            arr = new Trie[26];
        }
    }

    Trie root;


    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        
        Trie ptr = root;
        for(char ch : word.toCharArray()){
            if(ptr.arr[ch-'a'] == null){
                ptr.arr[ch-'a'] = new Trie();
            }
            ptr = ptr.arr[ch-'a'];
        }
        ptr.isEnd = true;

    }

    public boolean search(String word) {

        Trie ptr = root;
        for(char ch : word.toCharArray()){
            if(ptr.arr[ch-'a'] == null)
                return false;
            ptr = ptr.arr[ch-'a'];
        }
        return ptr.isEnd;

    }

    public boolean startsWith(String prefix) {

        Trie ptr = root;
        int count = 0;
        for(char ch : prefix.toCharArray()){
            if(ptr.arr[ch-'a'] == null)
                return false;

            count ++;
            ptr = ptr.arr[ch-'a'];
        }
        if(count == prefix.length())
        return true;

        return false;


    }
}


