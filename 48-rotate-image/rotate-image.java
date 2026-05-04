class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] transpose = new int[n][n];
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                transpose[row][col] = matrix[col][row];
            }
        }
        int left = 0;
        int right = n-1;
        while(left < right){
            for(int row=0;row<n;row++){
                int element = transpose[row][left];
                transpose[row][left] = transpose[row][right];
                transpose[row][right] = element;
            }
            ++left;
            --right;
        }
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                matrix[row][col] = transpose[row][col];
            }
        }
    }
}