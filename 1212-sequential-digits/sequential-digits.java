class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] totalSequences = generateTotalSequences();
        List<Integer> result = new ArrayList<>();
        for(int num: totalSequences){
            if(num >= low && num <= high){
                result.add(num);
            }
        }
        return result;
    }
    private int[] generateTotalSequences(){
        int[] totalSequences = new int[45];
        int index = 0;
        for(int i=1;i<10;i++){
            totalSequences[index++] = i;
        }
        for(int i=0;i<index;i++){
            int lastNum = totalSequences[i];
            int rem = lastNum % 10;
            if(rem < 9){
                totalSequences[index++] = lastNum * 10 + rem + 1;
            }
        }
        return totalSequences;
    }
}