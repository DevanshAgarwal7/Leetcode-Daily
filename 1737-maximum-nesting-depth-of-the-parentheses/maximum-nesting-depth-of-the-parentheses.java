class Solution {
    public int maxDepth(String s) {
        int max = 0;
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '('){
                st.push(ch);
            } else if(ch == ')'){
                max = Math.max(max, st.size());
                st.pop();
            }
        }
        return max;
    }
}