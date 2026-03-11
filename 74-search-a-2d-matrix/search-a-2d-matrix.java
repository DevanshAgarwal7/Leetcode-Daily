class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        List<Integer> list = Arrays.stream(matrix).flatMapToInt(Arrays::stream)
                    .boxed().collect(Collectors.toList());
        int left = 0;
        int right = list.size() - 1;
        while(left <= right){
            int mid = (left+right)/2;
            if(list.get(mid) == target){
                return true;
            } else if(list.get(mid) > target){
                --right;
            } else{
                ++left;
            }
        }
        return false;
    }
}