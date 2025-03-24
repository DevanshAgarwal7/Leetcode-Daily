class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] road: roads){
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adjList.get(u).add(new int[]{v, time});
            adjList.get(v).add(new int[]{u, time});
        }

        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> Long.compare(x[0], y[0]));
        pq.add(new long[]{0, 0});
        int[] countPath = new int[n];
        countPath[0] = 1;

        while(!pq.isEmpty()){
            long[] currNode = pq.poll();
            long time = currNode[0];
            int node = (int)currNode[1];
            for(int i=0;i<adjList.get(node).size();i++){
                int adjNode = adjList.get(node).get(i)[0];
                int adjNodeTime = adjList.get(node).get(i)[1];

                if(time + adjNodeTime < dis[adjNode]){
                    dis[adjNode] = time + adjNodeTime;
                    countPath[adjNode] = countPath[node] % mod;
                    pq.add(new long[]{dis[adjNode], adjNode});
                }
                else if(time + adjNodeTime == dis[adjNode]){
                    countPath[adjNode] = (countPath[adjNode] + countPath[node]) % mod;
                }
            }
        }
        return countPath[n-1];
    }
}