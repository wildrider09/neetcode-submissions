class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);

        dfs(nums, 0, res, set);

        for(List a : set)
            ans.add(a);
        
        return ans;
        
    }

    void dfs(int nums[], int index,  List<Integer> res, Set<List<Integer>> ans ){
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
