class Solution {
    public int longestSubsequence(int[] nums) {
        boolean allZero = true;
        int xor = 0;
        int n = nums.length;
        for(int element: nums){
            xor ^= element;
            if(xor > 0){
                allZero = false;
            }
        }
        if(xor > 0){
            return n;
        }
        return allZero ? 0: n-1;
    }
}