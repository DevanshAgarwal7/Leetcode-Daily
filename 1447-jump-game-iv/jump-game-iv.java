class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i], list -> new ArrayList<>()).add(i);
        } 

        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.add(new int[]{0, 0});
        vis[0] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int currDistance = curr[1];
            if(node == n-1){
                return currDistance;
            }

            if(node-1 >= 0 && !vis[node-1]){
                vis[node-1] = true;
                q.add(new int[]{node-1, currDistance+1});
            }
            if(node+1 < n && !vis[node+1]){
                vis[node+1] = true;
                q.add(new int[]{node+1, currDistance+1});
            }
            map.get(arr[node]).stream().filter(next -> !vis[next]).forEach(next -> q.add(new int[]{next, currDistance+1}));
            map.get(arr[node]).clear();
        }
        return -1;
    }
}