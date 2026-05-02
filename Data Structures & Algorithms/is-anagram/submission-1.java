class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        int temp[] = new int[26];
        for(int i=0; i< s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            temp[ch1 - 'a'] ++;
            temp[ch2 - 'a'] --;
        }

        for(int i : temp){
            if(i != 0)
                return false;
        }
        return true;

    }
}
