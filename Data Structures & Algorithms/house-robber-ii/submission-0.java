class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        if(n==0)
            return 0;
        else if(n ==1)
            return nums[0];
        else if(n==2)
            return Math.max(nums[0], nums[1]);

        int cache[] = new int[n];
        Arrays.fill(cache, -1);

        int cache1[] = new int[n];
        Arrays.fill(cache1, -1);

        return Math.max(dfs(nums, n-1, 0, cache), 
                        dfs(nums, n, 1, cache1));
    }

    int dfs(int cost[], int n, int index, int cache[]){
        if(index >= n) 
            return 0;
        
        if(cache[index]!=-1)
            return cache[index];
        
        return cache[index] = Math.max(cost[index] +  dfs(cost, n, index+2, cache),
                                                      dfs(cost, n, index+1, cache));
    }
}
