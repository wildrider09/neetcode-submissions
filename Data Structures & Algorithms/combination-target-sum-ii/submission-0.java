class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();

        dfs(nums, 0, 0, target, res, ans);

        return ans;
        
    }

    void dfs(int nums[], int index, int sum, int target, List<Integer> res, List<List<Integer>> ans){
        if(sum == target){
            ans.add(new ArrayList<>(res));
            return;
        }

        else if(sum > target || index == nums.length){
            return;
        }
        

        res.add(nums[index]);
        dfs(nums, index + 1, sum + nums[index], target, res, ans);

        res.remove(res.size()-1);

        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index ++;
        }

        dfs(nums, index + 1, sum, target, res, ans);
    }
}
