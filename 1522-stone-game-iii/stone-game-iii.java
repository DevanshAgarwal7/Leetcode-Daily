class Solution {
    private int[] memo;
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        //alice start the game
        int diff = solve(0, n, stoneValue);
        if(diff > 0){
            return "Alice";
        } else if(diff < 0){
            return "Bob";
        }
        return "Tie";
    }
    private int solve(final int index, final int n, final int[] stoneValue){
        //base case
        if(index >= n){
            return 0;
        }
        if(memo[index] != -1){
            return memo[index];
        }
        int diff = Integer.MIN_VALUE;
        diff = Math.max(diff, stoneValue[index] - solve(index+1, n, stoneValue));
        if(index+1 < n){
            diff = Math.max(diff, stoneValue[index] + stoneValue[index+1] - solve(index+2, n, stoneValue));
        }
        if(index+2 < n){
            diff = Math.max(diff, stoneValue[index] + stoneValue[index+1] + stoneValue[index+2] - solve(index+3, n, stoneValue));
        }
        return memo[index] = 
        diff;
    }
}