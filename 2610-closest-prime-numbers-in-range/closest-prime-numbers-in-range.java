class Solution {
    public int[] closestPrimes(int left, int right) {
        int num1=-1,num2=-1;
        int[] ans = new int[2];
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        while(left<=right){
            if(isPrime(left)){
                primeNumbers.add(left);
            }
            ++left;
        }
        System.out.println(primeNumbers);
        int curr = primeNumbers.size() - 1;
        int min = Integer.MAX_VALUE;
        while(curr > 0){
            if(primeNumbers.get(curr) - primeNumbers.get(curr-1) <= min){
                num1 = primeNumbers.get(curr-1);
                num2 = primeNumbers.get(curr);
                min = primeNumbers.get(curr) - primeNumbers.get(curr-1);
            }
            --curr;
        }
        ans[0] = num1;
        ans[1] = num2;
        return ans;
    }
    private boolean isPrime(int number){
        if(number == 1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}