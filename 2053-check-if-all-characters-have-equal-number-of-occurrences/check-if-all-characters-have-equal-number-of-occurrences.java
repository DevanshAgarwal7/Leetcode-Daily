class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }
        int freqCount = 0;
        for(int i=0;i<26;i++){
            if(freq[i] != 0){
                if(freqCount == 0){
                    freqCount = freq[i];
                } else if(freqCount != freq[i]){
                    return false;
                }
            }
        }
        return true;
    }
}