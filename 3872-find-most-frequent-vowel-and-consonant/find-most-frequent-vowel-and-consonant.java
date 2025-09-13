class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int vowel = 0;
        int consonent = 0;
        for(char ch='a'; ch<='z'; ch++){
            if(isVowel(ch)){
                vowel = Math.max(vowel, map.getOrDefault(ch, 0));
            } else{
                consonent = Math.max(consonent, map.getOrDefault(ch, 0));
            }
        }
        return vowel + consonent;
    }
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}