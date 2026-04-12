class Solution {
    private int n;
    private int m;
    private int[][][] dp;
    public int maximumAmount(int[][] coins) {
        n = coins.length;
        m = coins[0].length;
        dp = new int[n][m][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        return dfs(coins, 0, 0, 2);
    }
    private int dfs(int[][] coins, int row, int col, int k){
        if(row >= n || col >= m){
            return Integer.MIN_VALUE;
        }
        int coin = coins[row][col];
        if(row == n-1 && col == m-1){
            if(k>0){
                return Math.max(0, coin);
            }
            return coin;
        }
        if(dp[row][col][k] != Integer.MIN_VALUE){
            return dp[row][col][k];
        }
        //without neutralize
        int result = Math.max(dfs(coins, row, col+1, k), dfs(coins, row+1, col, k)) + coin;

        //with neutralize
        if(coin < 0 && k > 0){
            result = Math.max(result, Math.max(dfs(coins, row, col+1, k-1), dfs(coins, row+1, col, k-1)));
        }
        dp[row][col][k] = result;
        return dp[row][col][k];
    }
}