class Solution {
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int findMaxFish(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] != 0 && !vis[i][j]){
                    max = Math.max(max, dfs(i, j, m, n, grid, vis, grid[i][j]));
                }
            }
        }
        return max;
    }
    private int dfs(int row, int col, int m , int n, int[][] grid, 
    boolean[][] vis, int fish){
        vis[row][col] = true;
        for(int i=0;i<4;i++){
            int adjRow = row + direction[i][0];
            int adjCol = col + direction[i][1];
            if(adjRow >= 0 && adjRow < m && adjCol >= 0 && adjCol < n &&
            grid[adjRow][adjCol] != 0 && !vis[adjRow][adjCol]){
                fish += dfs(adjRow, adjCol, m, n, grid, vis, grid[adjRow][adjCol]);
            }
        }
        return fish;
    }
}