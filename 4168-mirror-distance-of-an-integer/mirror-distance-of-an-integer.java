class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }
    private int reverse(int n){
        int reverseNumber = 0;
        while(n > 0){
            reverseNumber = reverseNumber*10 + (n%10);
            n /= 10;
        }
        return reverseNumber;
    }
}