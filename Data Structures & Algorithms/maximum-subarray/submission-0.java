class Solution {
    public int maxSubArray(int[] nums) {

        if(nums.length ==0)
            return 0;
        if(nums.length ==1)
            return nums[0];

        int max = Integer.MIN_VALUE, res = 0;

        for(int i = 0; i<nums.length; i++){
            if((res+ nums[i]) > nums[i]){
                res = res + nums[i];
            }
            else
                res = nums[i];

            max = Math.max(res, max);
        }        

        return max;
    }
}
