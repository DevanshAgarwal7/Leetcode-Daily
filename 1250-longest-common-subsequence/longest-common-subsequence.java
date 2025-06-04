class Solution {
    private int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n+1][m+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return findLcs(text1.toCharArray(), text2.toCharArray(), n, m);
    }
    private int findLcs(char[] text1, char[] text2, int n, int m){
        //only base case
        if(n == 0 || m == 0){
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(text1[n-1] == text2[m-1]){
            dp[n][m] =  1 + findLcs(text1, text2, n-1, m-1);
        } else{
            dp[n][m] =  Math.max(findLcs(text1, text2, n, m-1), findLcs(text1, text2, n-1, m));
        }
        return dp[n][m];
    }
}