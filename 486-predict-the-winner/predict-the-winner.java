class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int scoreOfP1 = solveForP1(0, n-1, nums);
        int scoreOfP2 = sum - scoreOfP1;
        return scoreOfP1 >= scoreOfP2;
    }
    private int solveForP1(int i, int j, int[] nums){
        //base case
        if(i>j){
            return 0;
        }
        if(i==j){
            return nums[i];
        }
        int takeI = nums[i] + Math.min(solveForP1(i+2, j, nums), solveForP1(i+1, j-1, nums));
        int takeJ = nums[j] + Math.min(solveForP1(i+1, j-1, nums), solveForP1(i, j-2, nums));

        return Math.max(takeI, takeJ);
    }
}