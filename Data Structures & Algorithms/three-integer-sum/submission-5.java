class Solution {
    public List<List<Integer>> threeSum(int[] numbers) {

        List<List<Integer>> list= new ArrayList<>();
        Arrays.sort(numbers);
        int n = numbers.length;
        for(int i =0; i<n-2;i++){
            if (numbers[i] > 0) break;
            if(i>0 && numbers[i]==numbers[i-1]) continue;
            int l=i+1, r =n-1;
            while(l<r){
                int sum = numbers[i] + numbers[l] + numbers[r];
                if (sum > 0) 
                    r--;
                else if (sum < 0) 
                    l++;
                else{
                    list.add(Arrays.asList(numbers[i],numbers[l], numbers[r]));
                    l++;
                    while(l<r && numbers[l]==numbers[l-1])
                        l++;
                }
            }
        }

        return list;
        
    }
}