class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y-x);
        for(int happinessValue: happiness){
            pq.add(happinessValue);
        }
        int decreaseValue = 0;
        long maxHappiness = 0;
        while(k>0){
            if(pq.peek() - decreaseValue >= 0){
                maxHappiness += (pq.poll() - decreaseValue);
            }
            k--;
            decreaseValue++;
        }
        return maxHappiness;
    }
}