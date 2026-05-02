class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i =0; i<s.length(); i++)
            map.put(s.charAt(i), i);
        
        int start = 0, end = 0;
        while(start<=s.length()-1){
            for(int i=start; i<=end; i++){
                char ch = s.charAt(i);
                int lastOccurence = map.get(ch);

                if(lastOccurence>end)
                    end = lastOccurence;
            }
            ans.add((end-start+1));
            end ++;
            start = end;
        }

        return ans;
    }
}
