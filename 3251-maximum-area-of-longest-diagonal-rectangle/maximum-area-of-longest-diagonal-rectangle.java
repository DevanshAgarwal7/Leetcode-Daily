class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area = 0;
        double maxDiag = 0;
        for(int[] dimension: dimensions){
            double diag = Math.sqrt(dimension[0] * dimension[0] + dimension[1] * dimension[1]);
            if(maxDiag == diag){
                area = Math.max(area, dimension[0] * dimension[1]);
            }
            else if(maxDiag < diag){
                maxDiag = diag;
                area = dimension[0] * dimension[1];
            }
        }
        return area;
    }
}