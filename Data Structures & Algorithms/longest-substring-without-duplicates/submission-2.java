class Solution {
    public int lengthOfLongestSubstring(String s) {

       HashSet<Character> set = new HashSet<>();
        
       int l = 0, r = 0, ans = 0;
       while(r < s.length()){
            char ch = s.charAt(r);
            while(set.contains(ch) && l < r){
                set.remove(s.charAt(l));
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            set.add(ch);
            r++;
       }
       return ans;
        
    }
}
