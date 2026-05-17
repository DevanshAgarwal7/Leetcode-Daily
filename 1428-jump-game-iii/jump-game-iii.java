class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                int curr = q.poll();
                vis[curr] = true;
                if(arr[curr] == 0){
                    return true;
                }
                if(curr+arr[curr] < n && !vis[curr+arr[curr]]){
                    q.add(curr+arr[curr]);
                }
                if(curr - arr[curr] >= 0 && !vis[curr-arr[curr]]){
                    q.add(curr - arr[curr]);
                }
                --size;
            }
        }
        return false;
    }
}