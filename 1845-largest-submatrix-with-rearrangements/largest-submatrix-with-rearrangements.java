class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row > 0 && matrix[row][col] == 1) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }
            int[] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            for(int j=0;j<n;j++){
                int currArea = currRow[j] * (n-j); //height * base
                maxArea = Math.max(maxArea, currArea);
            }
        }
        
        return maxArea;
    }
}