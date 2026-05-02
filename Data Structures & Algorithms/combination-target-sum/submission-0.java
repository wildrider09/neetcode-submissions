class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        dfs(nums, 0, 0, target, res, ans);

        return ans;
        
    }

    void dfs(int nums[], int index, int sum, int target, List<Integer> res, List<List<Integer>> ans){
        if(sum > target || index == nums.length){
            return;
        }
        else if(sum == target){
            ans.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[index]);
        dfs(nums, index, sum + nums[index], target, res, ans);

        res.remove(Integer.valueOf(nums[index]));
        dfs(nums, index +1 , sum, target, res, ans);
    }
}

