class Solution {
    public int maxProduct(int n) {
        int firstLargest = 0;
        int secondLargest = 0;
        while(n > 0){
            int digit = n % 10;
            if(digit > firstLargest){
                secondLargest = firstLargest;
                firstLargest = digit;
            } else if(digit > secondLargest){
                secondLargest = digit;
            }
            n /= 10;
        }
        return firstLargest * secondLargest;
    }
}