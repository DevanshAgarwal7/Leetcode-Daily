class Solution {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private int m;
    private int n;
    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] > 0 && !vis[i][j]){
                    long sum = 0;
                    sum = dfs(i, j, grid, vis, sum);
                    if(sum % k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private long dfs(final int row, final int col, final int[][] grid, boolean[][] vis,
    long sum){
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0 || 
            vis[row][col]){
            return sum;
        }
        vis[row][col] = true;
        sum += grid[row][col];

        for(int i=0;i<4;i++){
            int dxRow = row + dx[i];
            int dyCol = col + dy[i];
            sum = dfs(dxRow, dyCol, grid, vis, sum);
        }
        return sum;
    }
}