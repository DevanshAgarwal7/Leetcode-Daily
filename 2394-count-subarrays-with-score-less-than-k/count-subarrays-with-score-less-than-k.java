class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        int n = nums.length;
        int left = 0;
        int right = 0;
        long sum = 0;
        while(right < n){
            int subArrayLength = right - left + 1;
            sum += nums[right];
            if(sum * subArrayLength < k){
                count += subArrayLength;
                ++right;
            }
            else{
                while(sum * subArrayLength >= k){
                    sum -= nums[left];
                    ++left;
                    subArrayLength = right - left + 1;
                }
                count += subArrayLength;
                ++right;
            }
        }
        return count;
    }
}