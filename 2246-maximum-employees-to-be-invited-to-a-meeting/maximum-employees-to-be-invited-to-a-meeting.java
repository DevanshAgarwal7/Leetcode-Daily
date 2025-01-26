class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        ArrayList<int[]> twoLengthCycles = new ArrayList<>();
        //have cycle
        int cycleMoreThanTwoLength = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                HashSet<Integer> set = new HashSet<>();
                int start = i;
                int curr = i;
                set.add(curr);
                while(!vis[curr]){
                    vis[curr] = true;
                    set.add(curr);
                    curr = favorite[curr];
                }
                int len = set.size();
                while(start != curr){
                    --len;
                    start = favorite[start];
                }
                if(len == 2){
                    twoLengthCycles.add(new int[]{curr, favorite[curr]});
                }
                cycleMoreThanTwoLength = Math.max(cycleMoreThanTwoLength, len);
            }
        }
        //count attach nodes on the cycle having length = 2;
        List<List<Integer>> reverseAdjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            reverseAdjList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            reverseAdjList.get(favorite[i]).add(i);
        }
        int maxTwoLengthCycles = 0;
        for(int[] twoLengthCycle: twoLengthCycles){
            maxTwoLengthCycles += (dfs(twoLengthCycle[0], twoLengthCycle[1], reverseAdjList)
            + dfs(twoLengthCycle[1], twoLengthCycle[0], reverseAdjList) + 2);
        }
        return Math.max(maxTwoLengthCycles, cycleMoreThanTwoLength);
    }
    private static int dfs(int node, int skip, List<List<Integer>> reverseAdjList){
        int len = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {node, 0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            len = Math.max(len, curr[1]);
            for(int adjNode: reverseAdjList.get(curr[0])){
                if(adjNode != skip){
                    q.add(new int[]{adjNode, curr[1] + 1});
                }
            }
        }
        return len;
    }
}