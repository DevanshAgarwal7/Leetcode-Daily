class Solution {
    public int sumFourDivisors(int[] nums) {
        int total_sum = 0;
        
        for (int num : nums) {
            int sum = sum_if_four(num);
            total_sum += sum;
        }
        
        return total_sum;
    }

    private int sum_if_four(int n) {
        int d1 = 0, d2 = 0;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (d1 == 0) {
                    d1 = i;
                    d2 = n / i;
                } else {
                    return 0;
                }
            }
        }

        if (d1 == 0) return 0;
        if (d1 == d2) return 0;

        return 1 + n + d1 + d2;
    }
}