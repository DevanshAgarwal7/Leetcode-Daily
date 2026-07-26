class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int productOfThreeLargestPositiveNumbers = nums[n-1] * nums[n-2] * nums[n-3];
        //this is done in case array has +ve and -ve numbers both then may
        //be max product comes with two largest -ve and one largest +ve value
        int productOfTwoLargestNegativeAndOnePositiveNumbers = nums[0] * nums[1] * nums[n-1];
        return Math.max(productOfThreeLargestPositiveNumbers, productOfTwoLargestNegativeAndOnePositiveNumbers);
    }
}