class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        if(nums[start] == target){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int index = start;
        while(index<n){
            if(nums[index] == target){
                min = Math.min(min, index-start);
            }
            ++index;
        }
        index = start-1;
        while(index >= 0){
            if(nums[index] == target){
                min = Math.min(min, start - index);
            }
            --index;
        }
        return min;
    }
}