class Solution {

        public boolean validTree(int numCourses, int[][] prerequisites) {
       
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        
        for(int i=0; i<numCourses; i++)
            map.put(i,new ArrayList<>());
        
        for(int i=0; i<prerequisites.length; i++){
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        if( callDfs(-1,0,map, visited) && visited.size()==numCourses)
            return true;

        return false;
    }

    boolean callDfs(int prev, int course, Map<Integer,List<Integer>> map, 
                    Set<Integer> visited){

        if(visited.contains(course))
            return false;
        
    
        visited.add(course);
        for(int k=0; k<map.get(course).size(); k++){
            if(map.get(course).get(k)==prev)
                continue;
            if(!callDfs(course, map.get(course).get(k), map, visited))  
                return false;
        }
        return true;
    }

}
