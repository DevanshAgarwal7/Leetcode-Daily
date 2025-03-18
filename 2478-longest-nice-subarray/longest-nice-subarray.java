class Solution {
    public int longestNiceSubarray(int[] nums) {
        //slinding window
        int n = nums.length;
        int maxLength = 1;
        int left = 0;
        int right = 0;
        int bitMask = 0;
        while(right < n){
            //shrink
            while((bitMask & nums[right]) != 0){
                bitMask = bitMask ^ nums[left];
                ++left;
            }
            bitMask = bitMask | nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
            ++right;
        }
        return maxLength;
    }
}