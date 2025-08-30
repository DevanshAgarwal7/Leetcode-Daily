class Solution {
    public boolean checkValid(int[][] matrix) {
        Set<Integer> set = new HashSet<>();
        int n = matrix.length;
        for(int[] row: matrix){
            for(int i=0;i<n;i++){
                set.add(row[i]);
            }
            if(set.size() != n){
                return false;
            }
            set.clear();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                set.add(matrix[j][i]);
            }
            if(set.size() != n){
                return false;
            }
            set.clear();
        }
        return true;
    }
}