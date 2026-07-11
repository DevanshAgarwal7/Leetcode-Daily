class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
       List<List<Integer>> adjList = new ArrayList<>();
       for(int i=0;i<n;i++){
        adjList.add(new ArrayList<>());
       } 
       for(int[] edge: edges){
        int u = edge[0];
        int v = edge[1];
        adjList.get(u).add(v);
        adjList.get(v).add(u);
       }
       boolean[] vis = new boolean[n];
       int count = 0;
       for(int i=0;i<n;i++){
        if(!vis[i]){
            int[] numberOfNodes = new int[1];
            int[] numberOfEdges = new int[1];
            dfs(i, adjList, vis, numberOfNodes, numberOfEdges);
            // System.out.println("Nodes: " + numberOfNodes[0] + ", Edges: " + numberOfEdges[0]);
            if(isCompleteComponent(numberOfNodes[0], numberOfEdges[0])){
                count++;
            }
        }
       }
       return count;
    }
    private void dfs(final int node, final List<List<Integer>> adjList, boolean[] vis,
        int[] numberOfNodes, int[] numberOfEdges){
            vis[node] = true;
            numberOfNodes[0]++;
            numberOfEdges[0] += adjList.get(node).size();
            for(int i=0;i<adjList.get(node).size();i++){
                int adjNode = adjList.get(node).get(i);
                if(!vis[adjNode]){
                    dfs(adjNode, adjList, vis, numberOfNodes, numberOfEdges);
                }
            }
    }
    private boolean isCompleteComponent(final int numberOfNodes, final int numberOfEdges){
        return (numberOfNodes * (numberOfNodes - 1)) == numberOfEdges;
    }
}