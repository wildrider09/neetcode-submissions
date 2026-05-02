class Solution {
    public int countComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for(int i=0; i<n; i++)
            map.put(i,new ArrayList<>());
        
        for(int i=0; i<edges.length; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                callDfs(-1,i,map, visited);
                count++;
            }
        }

        return count;
            
    }

    void callDfs(int prev, int node, Map<Integer,List<Integer>> map, 
                    Set<Integer> visited){

        if(visited.contains(node))
            return;
        
        visited.add(node);
        for(int k=0; k<map.get(node).size(); k++){
            if(map.get(node).get(k)==prev)
                continue;
            callDfs(node, map.get(node).get(k), map, visited);
        }
    }
}
