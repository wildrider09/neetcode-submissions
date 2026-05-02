class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();

        int l = 0, r = 0, maxf = 0, res = 0;
        while(r < s.length()){
            char ch = s.charAt(r);
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            maxf = Math.max(maxf, map.get(ch));

            while ( (r-l+1) - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l ++;
            }




            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}

