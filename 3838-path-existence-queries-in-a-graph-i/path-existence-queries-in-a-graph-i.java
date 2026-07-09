class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        //see solution section to understand the logic
        int[] component = new int[n];
        component[0] = 0;
        for(int i=1;i<n;i++){
            if(nums[i] - nums[i-1] <= maxDiff){
                component[i] = component[i-1];
            } else{
                component[i] = component[i-1] + 1;
            }
        }
        boolean[] result = new boolean[queries.length];
        for(int i=0; i<queries.length; i++){
            int u = queries[i][0];
            int v = queries[i][1];
            result[i] = (component[u] == component[v]);
        }
        return result;
    }
}