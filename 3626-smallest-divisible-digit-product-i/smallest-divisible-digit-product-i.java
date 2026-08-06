class Solution {
    public int smallestNumber(int n, int t) {
        while(getProductOfDigits(n) % t != 0){
            n++;
        }
        return n;
    }
    private int getProductOfDigits(int n){
        int productOfDigits = 1;
        while(n > 0){
            productOfDigits *= (n % 10);
            n /= 10;
        }
        return productOfDigits;
    }
}