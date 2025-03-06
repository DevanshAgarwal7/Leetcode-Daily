class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] result = new int[2];
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int[] row: grid){
            for(int element: row){
                if(set.contains(element)){
                    result[0] = element;
                }
                set.add(element);
            }
        }
        for(int i=1;i<=n*n;i++){
            if(!set.contains(i)){
                result[1] = i;
                break;
            }
        }
        return result;
    }
}