class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int cache[] = new int[cost.length+1];
        Arrays.fill(cache, -1);
        return Math.min(dfs(cost, 0, cache), dfs(cost, 1, cache));
    }

    int dfs(int cost[], int index, int cache[]){
        if(index >= cost.length) 
            return 0;
        
        if(cache[index]!=-1)
            return cache[index];
        
        return cache[index] = cost[index] + Math.min( dfs(cost, index+1, cache),
                                                      dfs(cost, index+2, cache));
    }
}
