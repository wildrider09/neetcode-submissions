class Solution {
    public String foreignDictionary(String[] words) {
      
   
        HashMap<Character, Set<Character>> edges = new HashMap<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                edges.put(ch, new HashSet<Character>());
            }
        }
        
        // Find edges
        for (int i = 1; i < words.length; i++) {
            char[] w1 = words[i-1].toCharArray(), w2 = words[i].toCharArray();
            if (w1.length > w2.length && words[i-1].startsWith(words[i])) return ""; // Invalid Order
            for (int j = 0; j < w1.length && j < w2.length; j++) {
                if (w1[j] != w2[j]) {
                    edges.get(w1[j]).add(w2[j]);
                    break;
                }
            }
        }
        
        // Topological sort with cycle detection for invalid order
        char[] order = new char[edges.size()];
        idx = edges.size() - 1;
        HashMap<Character, Boolean> visited = new HashMap<>(); // <visited nodes, not on current path>
        for (char node : edges.keySet()) {
            if (!dfs(edges, order, visited, node)) return ""; // Cycle Detected, Invalid Order
        }
        return new String(order);
    }
    
    private int idx;
    
    private boolean dfs(Map<Character, Set<Character>> edges, char[] order, Map<Character, Boolean> visited, char node) {
        if (visited.containsKey(node)) return visited.get(node);
        
        visited.put(node, false);
        for (char next : edges.get(node)) {
            if (!dfs(edges, order, visited, next)) return false; // Cycle Detected
        }
        visited.replace(node, true);
        order[idx--] = node; // Add to results reversely
        return true;
    }
}
