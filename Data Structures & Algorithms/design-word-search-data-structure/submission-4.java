class WordDictionary {

    class Trie{
        boolean isEnd;
        Trie []arr;

        public Trie(){
            isEnd = false;
            arr = new Trie[26];
        }
    }

    private Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {

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

        return solve(word, 0, root);
    }

    public boolean solve(String word, int i, Trie root) { 

        Trie curr = root;
        for(int j = i; j<word.length(); j++){
            char ch = word.charAt(j);

            if(ch == '.'){
                for(Trie child : curr.arr){
                    if(child != null && solve(word, j+1, child))
                        return true;
                }
                return false;
            }
            else{
                if(curr.arr[ch-'a'] == null)
                    return false;
            }
                curr = curr.arr[ch-'a'];
            
        }

        return curr.isEnd;
    }
}
