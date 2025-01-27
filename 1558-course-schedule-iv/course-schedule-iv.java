class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adjList.get(u).add(v);
        }
        List<Boolean> result = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int prerequisticCourse = queries[i][0];
            int afterPrerequisticCourse = queries[i][1];
            boolean[] vis = new boolean[numCourses];
            if(dfs(prerequisticCourse, adjList, vis, afterPrerequisticCourse)){
                result.add(true);
            } else{
                result.add(false);
            }
        }
        return result;
    }

    private boolean dfs(int node, List<List<Integer>> adjList, boolean[] vis,
    int afterPrerequisticCourse){
        if(node == afterPrerequisticCourse){
            return true;
        }
        vis[node] = true;
        for(int i=0;i<adjList.get(node).size();i++){
            int adjNode = adjList.get(node).get(i);
            if(!vis[adjNode]){
                if(dfs(adjNode, adjList, vis, afterPrerequisticCourse)){
                    return true;
                }
            }
        }
        return false;
    }
}