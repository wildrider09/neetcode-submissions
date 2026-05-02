class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        HashSet<Integer> ans= new LinkedHashSet<>();

        for(int i=0; i<numCourses; i++)
            map.put(i,new ArrayList<>());
        
        for(int i=0; i<prerequisites.length; i++)
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);

        for(int i=0; i<numCourses; i++){
            if(!callDfs(map, visited, i, ans))
                return new int[0];
            
        }

        return  ans.stream().mapToInt(Integer::intValue).toArray();
    }

    boolean callDfs( Map<Integer, List<Integer>> map, Set<Integer> visited,
                    int course, HashSet<Integer> ans){

        if(visited.contains(course))
            return false;

        if(map.get(course).isEmpty()){
            ans.add(course);
            return true;
        }

        visited.add(course);
        for(int k=0; k<map.get(course).size(); k++){
            if(!callDfs(map,visited,map.get(course).get(k), ans))
                return false;
        }
        visited.remove(course);
        map.put(course, new ArrayList<>());
        ans.add(course);
        return true;
    }
}
