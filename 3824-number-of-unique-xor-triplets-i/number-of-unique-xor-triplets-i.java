class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return n;
        }
        int result = 1;
        while(result <= n){
            result *= 2;
        }
        return result;
    }
}