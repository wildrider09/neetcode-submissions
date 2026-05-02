class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int t[][] = new int[n][m];
        for(int a[] : t)
            Arrays.fill(a, -1);

        return dfs(text1, text2, n-1, m-1, t);
    }

    int dfs(String s1, String s2, int n, int m, int t[][]){
        
        if(n<0 || m<0)
            return 0;

        if(t[n][m]!= -1)
            return t[n][m];
        
        if(s1.charAt(n) == s2.charAt(m))
            t[n][m] = 1 + dfs(s1, s2, n-1, m-1, t);
        else
            t[n][m] = Math.max(dfs(s1, s2, n, m-1, t), dfs(s1, s2, n-1, m, t));

        return t[n][m];
    }
}
