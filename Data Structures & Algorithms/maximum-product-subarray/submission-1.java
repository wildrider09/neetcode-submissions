class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = 1, curMin = 1;

        for (int num : nums) {
            int tmp = num * curMax;
            int tmp1 = num * curMin;
            curMax = Math.max(Math.max(tmp, tmp1), num);
            curMin = Math.min(Math.min(tmp, tmp1), num);
            res = Math.max(res, curMax);
        }
        return res;
    }
}