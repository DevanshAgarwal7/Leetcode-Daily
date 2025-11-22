class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for(int element: nums){
            count += Math.min(element%3, 3-(element%3));
        }
        return count;
    }
}