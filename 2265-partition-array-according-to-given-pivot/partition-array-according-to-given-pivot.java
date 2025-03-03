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
        int index = 0;
        for(int i=0; i<smallerThanPivot.size(); i++){
            result[index++] = nums[smallerThanPivot.get(i)];
        }
        for(int i=0; i<equalToPivot.size(); i++){
            result[index++] = nums[equalToPivot.get(i)];
        }
        for(int i=0; i<greaterThanPivot.size(); i++){
            result[index++] = nums[greaterThanPivot.get(i)];
        }
        return result;
    }
}