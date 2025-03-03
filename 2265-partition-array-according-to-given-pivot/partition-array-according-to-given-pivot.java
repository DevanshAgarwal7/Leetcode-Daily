class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        List<Integer> smallerThanPivot = new ArrayList<>();
        List<Integer> equalToPivot = new ArrayList<>();
        List<Integer> greaterThanPivot = new ArrayList<>();
        //getting index of all the smallest element from given pivot
        for(int i=0;i<n;i++){
            if(nums[i] < pivot){
                smallerThanPivot.add(i);
            } else if(nums[i] == pivot){
                equalToPivot.add(i);
            } else{
                greaterThanPivot.add(i);
            }
        }
        smallerThanPivot.addAll(equalToPivot);
        smallerThanPivot.addAll(greaterThanPivot);
        for(int i=0; i<smallerThanPivot.size(); i++){
            result[i] = nums[smallerThanPivot.get(i)];
        }
        return result;
    }
}