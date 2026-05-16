class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int element: nums){
            min = Math.min(min, element);
        }
        return min;
    }
}