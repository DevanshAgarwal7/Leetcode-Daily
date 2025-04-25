class Solution {
    public int majorityElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int element: arr){
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        int n = arr.length;
        int majority = -1;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int value = entry.getValue();
            if(value > n/2){
                majority = entry.getKey();
            }
        }
        return majority;
    }
}