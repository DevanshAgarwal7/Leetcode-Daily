class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(row > 0){
                    grid[row][col] += grid[row-1][col];
                }
            }
            int sum = 0;
            for(int col=0;col<m;col++){
                sum += grid[row][col];
                if(sum <= k){
                    ++count;
                }
            }
        }
        return count;
    }
}