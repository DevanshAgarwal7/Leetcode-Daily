class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        for(String str: text.split(" ")){
            boolean flag = true;
            for(char ch: brokenLetters.toCharArray()){
                if(str.contains(String.valueOf(ch))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ++count;
            }
        }
        return count;
    }
}