class Solution {
    private static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
     int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, n, m, board, word, vis, word.substring(0, 1), 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean dfs(int row, int col, int n, int m, char[][] mat, 
    String word, boolean[][] vis, String str, int index){
        if(str.equals(word)){
            return true;
        }
        if(str.length() >= word.length()){
            return false;
        }
        vis[row][col] = true;
        for(int i=0;i<4;i++){
            int adjRow = row + direction[i][0];
            int adjCol = col + direction[i][1];
            if(adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m &&
            !vis[adjRow][adjCol] && mat[adjRow][adjCol] == word.charAt(index+1)){
                if(dfs(adjRow, adjCol, n, m, mat, word, vis, str + mat[adjRow][adjCol], index+1)){
                    return true;
                }
            }
        }
        vis[row][col] = false;
        return false;
    }
}