class Solution {
    public char kthCharacter(int k) {
        String word = "a";
        int index = 0;
        while(word.length() < k){
            int length = word.length();
            for(int i=0;i<length;i++){
                char ch = word.charAt(i);
                word += (char)(ch + 1);
            }
        }
        return word.charAt(k-1);
    }
}