class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int index=0;index<nums.length;index++){
            if(nums[index] == target){
                list.add(index);
            }
        }
        return list;
    }
}