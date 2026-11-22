class Solution {
    public boolean checkString(String s) {
        boolean isBAppeared = false;
        int index = 0;
        int n = s.length();
        while(index < n){
            if(s.charAt(index) == 'b'){
                isBAppeared = true;
                index++;
                break;
            }
            index++;
        }

        while(index < n){
            if(s.charAt(index) == 'a'){
                return false;
            }
            index++;
        }

        return true;
    }
}