class Solution {
    public boolean doesAliceWin(String s) {
        if(s == null){
            return false;
        }
        int vowelCounts = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' 
            || s.charAt(i) == 'u'){
                ++vowelCounts;
            }
        }
        return vowelCounts > 0;
    }
}