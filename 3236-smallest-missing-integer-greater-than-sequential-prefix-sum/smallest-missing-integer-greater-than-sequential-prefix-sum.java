class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int total = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[i-1] + 1){
                break;
            }
            else{
                total += nums[i];
            }
        }
        while(set.contains(total)){
            total++;
        }
        return total;
    }
}