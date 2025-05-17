class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int index = n-1;
        int left = 0;
        int right = n-1;

        while(left <= right){
            int leftElement = Math.abs(nums[left]);
            int rightElement = Math.abs(nums[right]);
            if(rightElement > leftElement){
                result[index--] = rightElement * rightElement;
                --right;
            } else{
                result[index--] = leftElement * leftElement;
                ++left;
            }
        }
        return result;
    }
}