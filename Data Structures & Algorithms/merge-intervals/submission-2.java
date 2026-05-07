class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length<=1)
            return intervals;

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        List<int[]> res = new ArrayList<>();
        int prev[] = new int []{intervals[0][0], intervals[0][1]};

        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]<=prev[1]){
                prev[0] = Math.min(prev[0], intervals[i][0]);
                prev[1] = Math.max(prev[1], intervals[i][1]);
               } else {
                res.add(prev);
                prev = new int[]{intervals[i][0], intervals[i][1]};
            }
        }

       
        res.add(prev);
        
        return res.toArray(new int[res.size()][]);
        
    }
}
