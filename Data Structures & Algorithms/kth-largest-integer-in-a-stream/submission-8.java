class KthLargest {

    PriorityQueue<Integer> q = new PriorityQueue<>();
    int t=0;
    public KthLargest(int k, int[] nums) {
        t=k;
        for(int i=0; i<k && i<nums.length; i++){
            q.add(nums[i]);
        }

        for(int i=k; i<nums.length; i++){
            if(q.peek()<nums[i]){
                q.poll();
                q.add(nums[i]);
            }
        }
        
    }
    
    public int add(int val) {
        
        q.add(val);
        if(q.size()>t)
                q.poll();
        return q.peek();
    }
}
