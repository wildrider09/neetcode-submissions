class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        
        for(int i=0; i<numCourses; i++)
            map.put(i,new ArrayList<>());
        
        for(int i=0; i<prerequisites.length; i++)
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);

        for(int i=0; i<numCourses; i++){
            if(!callDfs(map, visited, i))
                return false;
            
        }

        return true;
    }

    boolean callDfs( Map<Integer, List<Integer>> map, Set<Integer> visited,
                    int course){

        if(visited.contains(course))
            return false;
        
    
        visited.add(course);
        for(int k=0; k<map.get(course).size(); k++){
            if(!callDfs(map,visited,map.get(course).get(k)))
                return false;
        }
        visited.remove(course);
        map.put(course, new ArrayList<>());
        return true;

    }
}
