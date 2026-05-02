class Solution {

    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) return res;
        
        dfs(0, "", digits);
        
        return res;
    }

    void dfs(int index, String ans, String digits){
        if(index == digits.length()){
            res.add(ans);
            return;
        }

        String temp = digitToChar[digits.charAt(index)-'0'];
        for(int i = 0; i < temp.length(); i++){
            dfs(index+1, ans + temp.charAt(i), digits);
        }
    }

}
