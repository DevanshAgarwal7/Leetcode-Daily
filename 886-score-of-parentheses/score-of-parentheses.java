class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        int depth = 0;
        int score = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                depth++;
            } else{
                if(s.charAt(i-1) == '('){
                    depth--;
                    score += Math.pow(2, depth);
                }
                else{
                    depth--;
                }
            }
        }
        return score;
    }
}