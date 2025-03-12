class Solution {
    public int maximumCount(int[] nums) {
        int positiveCount = 0;
        int negativeCount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0){
                ++negativeCount;
            } else if(nums[i] > 0){
                ++positiveCount;
            }
        }
        return Math.max(negativeCount, positiveCount);
    }
}