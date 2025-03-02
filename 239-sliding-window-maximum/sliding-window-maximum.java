class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n-k+1];
        int i = 0;
        for(int index=0;index<k;index++){
            //Removing the small index then the current index from deque 
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[index]){
                dq.removeLast();
            }
            dq.addLast(index);
        }
        //the element associated with the first index from the deque is always greatest in current subaray
        result[i++] = nums[dq.peekFirst()];
        for(int index=k;index<n;index++){
            //Remove the indexes from left side of deque who are not in the range of current subarray range
            //current subarray range - [leftIndex, index]
            int leftIndex = index - k + 1;
            while(!dq.isEmpty() && dq.peekFirst() < leftIndex){
                dq.removeFirst();
            }
            //Removing the small index then the current index from deque 
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[index]){
                dq.removeLast();
            }
            dq.addLast(index);

            result[i++] = nums[dq.peekFirst()];
        }
        return result;
    }
}