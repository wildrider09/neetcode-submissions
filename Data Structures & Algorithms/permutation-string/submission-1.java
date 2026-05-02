class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length())
            return false;

        int a[] = new int[26];
        int b[] = new int[26];
        int match = 0;

        for(int i = 0; i < s1.length(); i++){
            a[s1.charAt(i) - 'a'] ++;
            b[s2.charAt(i) - 'a'] ++;
        }

        for(int i = 0; i< 26; i++){
            if(a[i] == b[i])
                match++;
        }

        int l = 0;
        for(int r=s1.length(); r < s2.length(); r++){
            if(match == 26)
                return true;
            
            int index = s2.charAt(r) - 'a';
            b[index]++;
            if(a[index] == b[index]){
                match++;
            }else if(a[index] == b[index]-1){
                match--;
            }

            index = s2.charAt(l) - 'a';
            b[index]--;
            if(a[index] == b[index]){
                match++;
            }else if(a[index] == b[index]+1){
                match--;
            }
            l++;

        }

        return match == 26;
        
    }
}