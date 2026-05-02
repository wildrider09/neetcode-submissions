class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        dfs(nums, 0, res, ans);

        return ans;
        
    }

    void dfs(int nums[], int index,  List<Integer> res, List<List<Integer>> ans ){
        if(index >= nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[index]);
        dfs(nums, index +1, res, ans);

        res.remove(Integer.valueOf(nums[index]));
        dfs(nums, index +1, res, ans);
    }
}
