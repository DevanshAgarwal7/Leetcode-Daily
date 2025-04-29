class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long count = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();

        final int maxElement =  Arrays.stream(nums).max().getAsInt();

        while(right < n){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.containsKey(maxElement) && map.get(maxElement) >= k){
                count += (n - right);
                map.put(nums[left], map.get(nums[left]) - 1);
                ++left;
            }
            ++right;
        }
        return count;
    }
}