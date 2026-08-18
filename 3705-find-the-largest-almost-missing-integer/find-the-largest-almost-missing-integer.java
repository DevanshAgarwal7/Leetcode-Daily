class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if(k == n){
            return Arrays.stream(nums).max().getAsInt();
        }
        int[] freq = new int[51];
        for(int element: nums){
            freq[element]++;
        }
        if(k == 1){
            for(int i=50;i>=0;i--){
                if(freq[i] == 1){
                    return i;
                }
            }
            return -1;
        }
        int result = -1;
        if(freq[nums[0]] == 1){
            result = Math.max(result, nums[0]);
        }
        if(freq[nums[n-1]] == 1){
            result = Math.max(result, nums[n-1]);
        }
        return result;
    }
}