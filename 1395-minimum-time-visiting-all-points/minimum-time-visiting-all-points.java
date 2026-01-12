class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        int n = points.length;
        for(int i=0;i<n-1;i++){
            int currX = points[i][0];
            int currY = points[i][1];
            int targetX = points[i+1][0];
            int targetY = points[i+1][1];

            int diffX = Math.abs(currX - targetX);
            int diffY = Math.abs(currY - targetY);

            result += (Math.min(diffX, diffY) + (Math.max(diffX, diffY) - Math.min(diffX, diffY)));
            //or result = Math.max(diffX, diffY);
        }
        return result;
    }
}