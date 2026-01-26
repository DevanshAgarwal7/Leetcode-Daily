class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Math.abs(nums[0]-nums[1]);
        int left = 1;
        int right = 2;
        result.add(List.of(nums[0], nums[1]));
        while(right < n){
            int diff = Math.abs(nums[left]-nums[right]);
            if(diff < minDiff){
                result.clear();
                minDiff = diff;
                result.add(List.of(nums[left], nums[right]));
            }
            else if(diff == minDiff){
                result.add(List.of(nums[left], nums[right]));
            }
            left++;
            right++;
        }
        return result;
    }
}