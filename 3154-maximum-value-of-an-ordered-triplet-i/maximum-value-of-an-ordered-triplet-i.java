class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0L;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    max = Math.max(max, ((long)nums[i] - (long)nums[j]) * (long)nums[k]);
                }
            }
        }
        return max;
    }
}