class Solution {
    public String longestPalindrome(String s) {

        int l, r ;
        String res = "";
        for(int i = 0; i<s.length(); i++){
            l = i; r = i;
            while(l>=0 && r<=s.length()-1 && s.charAt(l) == s.charAt(r)){
                String temp = s.substring(l, r+1);
                if(temp.length()>res.length())
                    res = temp;
                l--;
                r++;
            }
            l = i; r = i+1;
            while(l>=0 && r<=s.length()-1 && s.charAt(l) == s.charAt(r)){
                String temp = s.substring(l, r+1);
                if(temp.length()>res.length())
                    res = temp;
                l--;
                r++;
            }
        }
        return res;
    }
}
