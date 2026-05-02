class Solution {
    public int maxProfit(int[] nums) {

        if(nums.length <= 1)
            return 0;
        
        int maxProfit = 0;
        int l = 0, r =1;

        while( r < nums.length){

            if(nums[l] < nums[r]){
                maxProfit = Math.max(maxProfit, nums[r] - nums[l]);
            } else {
                l = r;
            }
            
            r++;
        }

        return maxProfit;

        
    }
}
