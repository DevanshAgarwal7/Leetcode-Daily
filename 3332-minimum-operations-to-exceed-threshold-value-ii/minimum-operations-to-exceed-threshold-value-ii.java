class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(nums[i] < k){
                pq.add((long)nums[i]);
            }
        }
        int count = 0;
        while(!pq.isEmpty() && pq.size() >= 2){
            long x = pq.poll();
            long y = pq.poll();
            long result = Math.min(x, y) * 2 + Math.max(x, y);
            if(result < k){
                pq.add(result);
            }
            ++count;
        }
        //edge case
        if(!pq.isEmpty() && pq.size() < 2 && pq.peek() < k){
            //System.out.println(pq.peek());
            ++count;
        }
        return count;
    }
}