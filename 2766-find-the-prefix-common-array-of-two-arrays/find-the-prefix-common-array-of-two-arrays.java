class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] prefixArray = new int[n];
        for(int currIndex=0;currIndex<n;currIndex++){
            int commonCount = 0;
            for(int aIndex=0;aIndex<=currIndex;aIndex++){
                for(int bIndex=0;bIndex<=currIndex;bIndex++){
                    if(A[aIndex] == B[bIndex]){
                        ++commonCount;
                        break;
                    }
                }
            }
            prefixArray[currIndex] = commonCount;
        }
        return prefixArray;
    }
}