class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int odd = 0;
        int even = 1;
        int prefixSum = 0;
        int count = 0;

        for(int num: arr){
            prefixSum += num;
            if(prefixSum % 2 == 0){
                count += odd;
                even++;
            } else{
                count += even;
                odd++;
            }

            count %= mod;
        }
        return count % mod;
    }
}