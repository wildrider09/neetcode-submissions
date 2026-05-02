class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        int copyQuery[] = queries.clone();
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        Arrays.sort(queries);

        int []ans = new int[queries.length];
        Map<Integer, Integer> res = new HashMap<>();
        int ptr=0;

        for(int i=0; i<queries.length; i++){
            int query = queries[i];
            while(ptr < intervals.length && intervals[ptr][0]<=query){
                queue.add(new int[] {(intervals[ptr][1]- intervals[ptr][0]+1), 
                        intervals[ptr][1]});
                ptr ++;
            }
            while(!queue.isEmpty()){
                int temp[]= queue.peek();
                if(temp[1]>=query){
                    res.put(query, temp[0]);
                    break;
                }
                else
                    queue.poll();
            }

            if(queue.isEmpty())
                res.put(query,-1);
        }

        for (int j = 0; j < copyQuery.length; j++) {
            ans[j] = res.get(copyQuery[j]);
        }

        return ans;
    }
}
