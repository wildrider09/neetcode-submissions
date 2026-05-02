class Solution {
    public boolean canJump(int[] nums) {

        int high = 0;
        for(int i=0; i<nums.length; i++){

            high = Math.max(high, nums[i]);
            if(high ==0 && i != nums.length -1)
                return false;

            high -= 1;

        }

        return true;
        
    }
}
