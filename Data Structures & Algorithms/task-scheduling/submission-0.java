class Solution {
    public int leastInterval(char[] tasks, int n) {

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        ArrayDeque<int[]> process = new ArrayDeque<>();
        int time = 0;
        int num[]= new int[26];

        for(char task : tasks)
            num[task-'A'] += 1;
        
        for(int i=0; i<26; i++){
            if(num[i]>0)
                q.add(num[i]);
        }
        
        while(!q.isEmpty() || !process.isEmpty()){
            time ++;

            if(q.isEmpty())
                time= process.getFirst()[1];
            else {
                int temp = q.poll() - 1;
                if(temp > 0)
                    process.addLast(new int[]{temp, time+n});
            }

            if(!process.isEmpty() && process.getFirst()[1]==time)
                q.add(process.removeFirst()[0]);
        }

        return time;

    }
}
