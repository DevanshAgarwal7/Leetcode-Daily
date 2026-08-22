class Solution {
    public boolean checkDivisibility(int n) {
        int sumOfDigit = 0;
        int productOfDigit = 1;
        int number = n;
        while(number > 0){
            int digit = number % 10;
            sumOfDigit += digit;
            productOfDigit *= digit;
            number /= 10;
        }
        return (n % (sumOfDigit + productOfDigit)) == 0;
    }
}