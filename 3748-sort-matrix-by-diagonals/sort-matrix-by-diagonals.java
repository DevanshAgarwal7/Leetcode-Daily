class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n][n];
        List<Integer> list = new ArrayList<>();
        //centre diagonal
        for(int i=0;i<n;i++){
           list.add(grid[i][i]);
        }
        list.sort(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            result[i][i] = list.get(i);
        }

        list.clear();
        //upper triangle diagonals
        for(int i=1;i<n;i++){
            for(int j=0;i+j<n;j++){
                list.add(grid[j][i+j]);
            }
            Collections.sort(list);
            for(int j=0;i+j<n;j++){
                result[j][i+j] = list.get(j);
            }
            list.clear();
        }

        //lower triangle diagnoals
        for(int i=0;i<n;i++){
            for(int j=1;i+j<n;j++){
                list.add(grid[i+j][j-1]);
            }
            list.sort(Collections.reverseOrder());
            for(int j=1;i+j<n;j++){
                result[i+j][j-1] = list.get(j-1);
            }
            list.clear();
        }
        return result;
    }
}