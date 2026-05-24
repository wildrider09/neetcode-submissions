class Solution {

    Map<Character, Boolean> visited = new HashMap<>();
    List<Character> result = new ArrayList<>();
    HashMap<Character, Set<Character>> edges = new HashMap<>();
    

    public String foreignDictionary(String[] words) {
      
   
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                edges.put(ch, new HashSet<Character>());
            }
        }
        
        // Find edges
        for (int i = 1; i < words.length; i++) {
            char[] w1 = words[i-1].toCharArray(), w2 = words[i].toCharArray();
            if (w1.length > w2.length && words[i-1].startsWith(words[i])) return "";
            for (int j = 0; j < w1.length && j < w2.length; j++) {
                if (w1[j] != w2[j]) {
                    edges.get(w1[j]).add(w2[j]);
                    break;
                }
            }
        }
        
        
        
        for (char c : edges.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }

        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean dfs(char ch) {
        if (visited.containsKey(ch)) {
            return visited.get(ch);
        }

        visited.put(ch, true);
        for (char next : edges.get(ch)) {
            if (dfs(next)) {
                return true;
            }
        }
        visited.put(ch, false);
        result.add(ch);
        return false;
    }
}