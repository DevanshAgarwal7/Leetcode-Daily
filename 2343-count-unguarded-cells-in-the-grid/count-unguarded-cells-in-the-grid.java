class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] vis = new char[m][n];
        for(int i=0;i<guards.length;i++){
            int row = guards[i][0];
            int col = guards[i][1];
            vis[row][col] = 'G';
        }
        for(int i=0;i<walls.length;i++){
            int row = walls[i][0];
            int col = walls[i][1];
            vis[row][col] = 'W';
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] == 'G'){
                    dfs(vis, i, j, m, n);
                }
                // System.out.print(vis[i][j] + " ");
            }
            // System.out.println();
        }

        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] != 'G' && vis[i][j] != 'W' && vis[i][j] != 'X'){
                    ++count;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] vis, int row, int col, int m, int n){
        //guarding east
        for(int i=row-1;i>=0;i--){
            if(vis[i][col] == 'G' || vis[i][col] == 'W'){
                break;
            } else{
                vis[i][col] = 'X';
            }
        }

        //guarding north
        for(int j=col+1;j<n;j++){
            if(vis[row][j] == 'G' || vis[row][j] == 'W'){
                break;
            } else{
                vis[row][j] = 'X';
            }
        }

        //guarding west
        for(int i=row+1;i<m;i++){
            if(vis[i][col] == 'G' || vis[i][col] == 'W'){
                break;
            } else{
                vis[i][col] = 'X';
            }
        }

        //guarding south
        for(int j=col-1;j>=0;j--){
            if(vis[row][j] == 'G' || vis[row][j] == 'W'){
                break;
            } else{
                vis[row][j] = 'X';
            }
        }
    }
}