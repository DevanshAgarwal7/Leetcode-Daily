class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<Node>> adjList = new ArrayList<>();
        for(int i=1;i<=n+1;i++){
            adjList.add(new ArrayList<Node>());
        }
        for(int[] road: roads){
            int u = road[0];
            int v = road[1];
            int dis = road[2];

            adjList.get(u).add(new Node(v, dis));
            adjList.get(v).add(new Node(u, dis));
        }

        Queue<Integer> q = new LinkedList<>();
        int result = Integer.MAX_VALUE;
        boolean[] vis = new boolean[n+1];

        q.add(1);
        vis[1] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(Node node: adjList.get(curr)){
                int v = node.getDest();
                int distance = node.getDistance();

                result = Math.min(result, distance);

                if(!vis[v]){
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
        return result;
    }
}
class Node{
    private int dest;
    private int distance;
    Node(int dest, int distance){
        this.dest = dest;
        this.distance = distance;
    }

    public int getDest(){
        return dest;
    }

    public int getDistance(){
        return distance;
    }
}