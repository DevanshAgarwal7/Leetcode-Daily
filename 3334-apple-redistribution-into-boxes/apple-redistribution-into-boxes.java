class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int count = 0;
        Integer[] capacityArray = new Integer[capacity.length];
        for(int i=0;i<capacity.length;i++){
            capacityArray[i] = capacity[i];
        }
        Arrays.sort(capacityArray, Collections.reverseOrder());
        int totalApples = Arrays.stream(apple).sum();
        while(totalApples > 0){
            totalApples -= capacityArray[count++];
        }
        return count;
    }
}