class Solution {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        //start from (0,0)
        pq.add(new int[] {grid[0][0], 0, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currDistance = curr[0];
            int row = curr[1];
            int col = curr[2];

            vis[row][col] = true;

            if(row == n-1 && col == n-1){
                return currDistance;
            }

            for(int i=0;i<4;i++){
                int neighbourRow = row + dx[i];
                int neighbourCol = col + dy[i];

                if(neighbourRow >= 0 && neighbourRow < n && neighbourCol >= 0 && 
                neighbourCol < n && !vis[neighbourRow][neighbourCol]){
                    int distance = Math.max(currDistance, grid[neighbourRow][neighbourCol]);
                    pq.add(new int[] {distance, neighbourRow, neighbourCol});
                }
            }
        }
        return -1;
    }
}