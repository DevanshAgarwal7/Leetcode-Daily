class Solution {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        int num = 1;
        while(num <= n){
            if(num % m != 0){
                num1 += num;
            } else{
                num2 += num;
            }
            ++num;
        }
        return num1 - num2;
    }
}