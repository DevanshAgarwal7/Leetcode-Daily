class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            int original = nums.get(i);
            int candidate = -1;
            for(int j=1;j<original;j++){
                if((j | (j+1)) == original){
                    candidate = j;
                    break;
                }
            }
            result[i] = candidate;
        }
        return result;
    }
}