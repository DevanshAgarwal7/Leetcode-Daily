class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            if(i>0 && nums[i-1] == nums[i]){
                continue;
            }
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    while(j<k && nums[j-1] == nums[j]){
                        ++j;
                    }
                } else if(sum < 0){
                    ++j;
                } else{
                    --k;
                }
            }
        }
        return result;
    }
}