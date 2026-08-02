class Solution {
    private int[][] memo;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        memo = new int[n+1][n+1];
        int sum = Arrays.stream(piles).sum();
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));
        //assuming alice starts the game
        int pointsAliceCollects = solveForAlice(0, n-1, piles);
        int pointsBobCollects = sum - pointsAliceCollects;

        return pointsAliceCollects > pointsBobCollects;

    }

    private int solveForAlice(final int i, final int j, final int[] piles){
        //base cases
        if(i > j){
            return 0;
        }
        if(i == j){
            return piles[i];
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        int takeI = piles[i] + Math.min(solveForAlice(i+2, j, piles), solveForAlice(i+1, j-1, piles));
        int takeJ = piles[j] + Math.min(solveForAlice(i+1, j-1, piles), solveForAlice(i, j-2, piles));

        return memo[i][j] = Math.max(takeI, takeJ);
    }
}