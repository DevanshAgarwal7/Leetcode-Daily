class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums1[i][0], nums1[i][1]);
        }
        for(int i=0;i<m;i++){
            map.put(nums2[i][0], map.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
        }
        int[][] result = new int[map.size()][2];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            result[index][0] = entry.getKey();
            result[index++][1] = entry.getValue();
        }
        Arrays.sort(result, (data1, data2) -> data1[0] - data2[0]);
        return result;
    }
}