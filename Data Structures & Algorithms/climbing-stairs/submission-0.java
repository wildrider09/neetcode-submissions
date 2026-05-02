class Solution {
    public int climbStairs(int n) {

        int cache[] = new int[n];
        Arrays.fill(cache, -1);
        return dfs(n, 0, cache);
    }

    int dfs(int n, int i, int cache[]){
        if(i>=n) return i==n ? 1 : 0;
        if(cache[i]!=-1)    return cache[i];

        return cache[i] = dfs(n, i+1, cache) + dfs(n, i+2, cache);
    }
}
