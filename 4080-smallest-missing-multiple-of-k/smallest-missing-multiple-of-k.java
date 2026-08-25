class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int element: nums){
            set.add(element);
        }
        int result = k;
        while(set.contains(result)){
            result += k;
        }
        return result;
    }
}