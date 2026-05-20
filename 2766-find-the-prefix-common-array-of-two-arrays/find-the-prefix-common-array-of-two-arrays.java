class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n+1];
        int commonCount = 0;
        int[] result = new int[n];
        for(int index=0;index<n;index++){
            int elementA = A[index];
            ++freq[elementA];
            if(freq[elementA] == 2){
                ++commonCount;
            }
            int elementB = B[index];
            ++freq[elementB];
            if(freq[elementB] == 2){
                ++commonCount;
            }
            result[index] = commonCount;
        }
        return result;
    }
}