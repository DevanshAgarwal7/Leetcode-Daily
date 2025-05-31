class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int[] row: matrix){
            for(int element: row){
                pq.add(element);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}