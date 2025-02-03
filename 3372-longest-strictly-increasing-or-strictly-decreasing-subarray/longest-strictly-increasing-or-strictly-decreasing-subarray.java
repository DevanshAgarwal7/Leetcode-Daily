class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int result = 1;
        int length = 1;
        int i=1;
        while(i<nums.length){
            if(nums[i] < nums[i-1]){
                result = Math.max(result, ++length);
                i++;
            } else{
                length = 1;
                i++;
            }
        }
        length = 1;
        i=1;
        while(i<nums.length){
            if(nums[i] > nums[i-1]){
                result = Math.max(result, ++length);
                i++;
            } else{
                length = 1;
                i++;
            }
        }
        return result;
    }
}