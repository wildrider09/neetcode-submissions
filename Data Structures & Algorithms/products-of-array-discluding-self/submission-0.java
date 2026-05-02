class Solution {
    public int[] productExceptSelf(int[] nums) {

        if(nums.length == 0)
            return new int[]{};

        int tmp = 1;
        int prod[] = new int[nums.length];
        prod[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            prod[i] = prod[i-1] * nums[i-1];
        }

        for (int i = nums.length-2; i >= 0; i--) {
            tmp = tmp * nums[i+1];
            prod[i] = tmp * prod[i];
        }

        return prod;


        
    }
}  
