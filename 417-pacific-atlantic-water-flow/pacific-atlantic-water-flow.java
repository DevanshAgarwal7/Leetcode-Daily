class Solution {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int m;
    private static int n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boolean[][] vis = new boolean[m][n];
                boolean[] isFlowInPacific = new boolean[1];
                boolean[] isFlowInAtlantic = new boolean[1];
                dfs(i, j, heights, vis, isFlowInPacific, isFlowInAtlantic);
                if(isFlowInPacific[0] && isFlowInAtlantic[0]){
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }
    private static void dfs(int row, int col, final int[][] heights, boolean[][] vis,
    boolean[] isFlowInPacific, boolean[] isFlowInAtlantic){

        vis[row][col] = true;
        for(int i=0;i<4;i++){
            int neighbourRow = row + dx[i];
            int neighbourCol = col + dy[i];

            if(neighbourRow < 0 || neighbourCol < 0){
                isFlowInPacific[0] = true;
            }
            if(neighbourRow == m || neighbourCol == n){
                isFlowInAtlantic[0] = true;
            }

            if(neighbourRow >= 0 && neighbourCol >= 0 && neighbourRow < m &&
            neighbourCol < n && heights[neighbourRow][neighbourCol] <= heights[row][col]
            && !vis[neighbourRow][neighbourCol]){
                dfs(neighbourRow, neighbourCol, heights, vis, isFlowInPacific, isFlowInAtlantic);
            }
        }
    }
}