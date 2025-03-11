class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int count = 0;
        while(right < n){
            if(right - left + 1 >= 3 && substringHasRequiredCharacters(s.substring(left, right+1))){
                count += n-right;
                ++left;
                while(left < right && right - left + 1 >= 3 && substringHasRequiredCharacters(s.substring(left, right+1))){
                    count += n-right;
                    ++left;
                }
            }
            ++right;
        }
        return count;
    }
    private boolean substringHasRequiredCharacters(final String str){
        return str.contains("a") && str.contains("b") && str.contains("c");
    }
}