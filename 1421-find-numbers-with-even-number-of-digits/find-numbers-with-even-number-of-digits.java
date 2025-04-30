class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int element: nums){
            if(element >= 10 && element < 100){
                ++count;
            } else if(element >= 1000 && element < 10000){
                ++count;
            } else if(element == 100000){
                ++count;
            }
        }
        return count;
    }
}