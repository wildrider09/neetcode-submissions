public class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> arr[] = new List[nums.length+1];
        int ans[] = new int[k];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[entry.getValue()].add(entry.getKey());
        }

        int index = 0;        
        for (int i = nums.length; i > 0 && index < k; i--) {
            for(int temp : arr[i]){
                if(index == k)
                    return ans;
                ans[index++] = temp;
            }
        }
        return ans;
    }
}