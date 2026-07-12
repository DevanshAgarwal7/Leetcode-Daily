class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] copy = Arrays.stream(arr).toArray();
        Arrays.sort(copy);

        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[n];
        int rank = 1;
        for(int i=0;i<n;i++){
            if(!map.containsKey(copy[i])){
                map.put(copy[i], rank++);
            }
        }
        for(int i=0;i<n;i++){
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}