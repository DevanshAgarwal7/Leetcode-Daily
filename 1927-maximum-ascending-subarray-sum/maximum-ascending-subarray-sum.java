class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = 0;
        int sum = nums[0];
        int n = nums.length;
        int i=1;
        while(i<n){
            if(nums[i] > nums[i-1]){
                sum += nums[i];
            } else{
                max = Math.max(max, sum);
                sum = nums[i];
            }
            ++i;
        }
        max = Math.max(max, sum);
        return max;
    }
}