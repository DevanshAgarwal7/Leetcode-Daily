class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int right = 0;
        int[] freq = new int[26];
        int n = s.length();
        int result = 0;
        while(right < n){
            int ch = s.charAt(right) - 'a';
            freq[ch]++;
            while(freq[ch] > 2){
                int ch2 = s.charAt(left) - 'a';
                freq[ch2]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}