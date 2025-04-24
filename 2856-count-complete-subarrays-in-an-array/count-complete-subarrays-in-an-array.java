class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> originalArraySet = new HashSet<>();
        for(int element: nums){
            originalArraySet.add(element);
        }
        int numberOfDitinctElements = originalArraySet.size();
        int count = 0;
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < n){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() == numberOfDitinctElements){
                count += n - right; //right tak ki subaaray and usse aage ke elements agar le tho kitni subrray hongi ---unka total
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                ++left;
            }
            ++right;
        }
        return count;
    }
}