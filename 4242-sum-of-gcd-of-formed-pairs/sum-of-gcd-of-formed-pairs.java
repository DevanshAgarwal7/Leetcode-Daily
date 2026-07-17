class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int currMax = nums[0];
        int[] prefixGcd = new int[n];
        prefixGcd[0] = gcd(nums[0], currMax);
        for(int i=1;i<n;i++){
            currMax = Math.max(nums[i], currMax);
            prefixGcd[i] = gcd(nums[i], currMax);
        }
        Arrays.sort(prefixGcd);
        int left = 0;
        int right = n-1;
        long sum = 0;
        while(left < right){
            sum += gcd(prefixGcd[left++], prefixGcd[right--]);
        }
        return sum;
    }
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}