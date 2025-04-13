class Solution {
    public String smallestPalindrome(String s) {
         int n = s.length();
        if(n <= 1){
            return s;
        }
        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }
        int oddCount = 0;
        char oddCh = 0;
        for(int i=0;i<26;i++){
            if(freq[i] % 2 != 0){
                oddCount++;
                oddCh = (char)(i + 'a');
            }
        }
        if(oddCount > 1){
            return "";
        }
        char[] result = new char[n];
        int left = 0;
        int right = n-1;
        for(int i=0;i<26;i++){
            if(freq[i] != 0){
                char ch = (char)(i + 'a');
                while(freq[i] >= 2){
                    result[left++] = ch;
                    result[right--] = ch;
                    freq[i] -= 2;
                }
            }
        }
        if(oddCount == 1){
            result[left] = oddCh;
        }
        return new String(result);
    }
}