class Solution {
    public int rob(int[] nums) {
        int cache[] = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs(nums, 0, cache);
    }

    int dfs(int nums[], int index, int cache[]){
        if(index >= nums.length)
            return 0;
        if(cache[index]!=-1)
            return cache[index];
        
        cache[index] = Math.max(nums[index] + dfs(nums, index + 2, cache),
                                dfs(nums, index + 1, cache));

        return cache[index];
    }
}
