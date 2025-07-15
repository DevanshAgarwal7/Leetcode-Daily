class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3){
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonent = false;
        for(char ch: word.toCharArray()){
            if(Character.isLetter(ch)){
                ch = Character.toLowerCase(ch);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    hasVowel = true;
                } else{
                    hasConsonent = true;
                }
            } else if(!Character.isDigit(ch)){
                return false;
            }
        }
        return hasVowel && hasConsonent;
    }
}