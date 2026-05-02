class Solution {
    public int jump(int[] nums) {
        
        int left = 0, right = 0, dist = 0, n = nums.length, ans = 0;

        while(right < n-1){
            dist = 0;
            for(int i = left; i<=right ; i++){
                dist = Math.max(dist, i + nums[i]);
            }   
            left = right+1;
            right = dist;
            ans++;
        }

        return ans;
    }
}
