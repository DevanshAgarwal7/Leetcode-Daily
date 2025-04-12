class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int n = image.length;
        int m = image[0].length;
        int[][] copy = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[i][j] = image[i][j];
            }
        }
        
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        
        q.add(new Pair(sr, sc));
        int oldColor = copy[sr][sc];
        
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            // System.out.println("row: " + row + ", col: " + col);
            vis[row][col] = true;
            for(int i=0;i<4;i++){
                int adjRow = row + dx[i];
                int adjCol = col + dy[i];
                if(adjRow >=0 && adjRow < n && adjCol >= 0 && adjCol < m && !vis[adjRow][adjCol]
                && copy[adjRow][adjCol] == oldColor){
                    q.add(new Pair(adjRow, adjCol));
                }
                copy[row][col] = color;
            }
        }
        return copy;
    }
    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}