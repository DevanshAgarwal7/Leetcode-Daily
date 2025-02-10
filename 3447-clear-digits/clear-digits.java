class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int i=0;
        while(i<n){
            char ch = s.charAt(i);
            if(isNumberic(ch)){
                if(!st.isEmpty() && !isNumberic(st.peek())){
                    st.pop();
                }
            } else{
                st.push(ch);
            }
            ++i;
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        return str.reverse().toString();
    }
    private boolean isNumberic(char ch){
        return ch -'0' >= 0 && ch-'0' <= 9;
    }
}