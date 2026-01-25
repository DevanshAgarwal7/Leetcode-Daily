class Solution {
    public int minimumDifference(int[] nums, int k) {
        int minDiff = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = k-1;
        while(right < n){
            int diff = nums[right] - nums[left];
            minDiff = Math.min(minDiff, diff);
            left++;
            right++;
        }
        return minDiff;
    }
}