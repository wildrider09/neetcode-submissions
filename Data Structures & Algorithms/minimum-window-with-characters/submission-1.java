class Solution {
    public String minWindow(String s, String t) {

        if (t.isEmpty()) return "";

        int n = s.length();
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>(); 

        int max = Integer.MAX_VALUE;
        int []ans = {-1, -1};

        int have  = 0; 

        int l = 0, r = 0;

        for(char ch : t.toCharArray())
            tMap.put( ch, tMap.getOrDefault(ch, 0) + 1);
        
        int want = tMap.size();

        while(r < n){

            char c = s.charAt(r);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1); 

            if(tMap.containsKey(c) &&
               sMap.get(c) == tMap.get(c))
                have ++;
            
            while(have == want){
                if((r-l+1)<max){
                    ans[0] = l; ans[1] = r;
                    max = r - l + 1;
                }
               
                char ch = s.charAt(l);
                sMap.put(ch, sMap.get(ch) - 1);

                if( tMap.containsKey(ch) &&
                    sMap.get(ch) < tMap.get(ch))
                    have--;
                l++;
            }
            r++;
        }


        return max==Integer.MAX_VALUE ? "" : s.substring(ans[0], ans[1] + 1);
        
    }
}
