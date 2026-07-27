class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int firstLargest = 0;
        int secondLargest = 0;
        for(int num: nums){
            if(num > firstLargest){
                secondLargest = firstLargest;
                firstLargest = num;
            } else if(num > secondLargest){
                secondLargest = num;
            }
        }
        return (firstLargest - 1) * (secondLargest - 1);
    }
}