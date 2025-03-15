class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //ye mene khud code kiya hai.
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.min(backtracking(0, n, cost, dp), backtracking(1, n, cost, dp));
    }
    private int backtracking(int currStep, int n, int[] cost, int[] dp){
        //base cases
        if(currStep >= n){
            return 0;
        }
        if(dp[currStep] != -1){
            return dp[currStep];
        }
        int oneStepTaken = backtracking(currStep + 1, n, cost, dp);
        int twoStepTaken = backtracking(currStep + 2, n, cost, dp);
        dp[currStep] = cost[currStep] + Math.min(oneStepTaken, twoStepTaken);
        return dp[currStep];
    }
}