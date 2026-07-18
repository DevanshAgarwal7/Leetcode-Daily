class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        return gcd(min, max);
    }
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}