class Solution {
    public int[] sumZero(int n) {
        boolean isEven = n%2 == 0 ? true : false;
        int[] result = new int[n];
        if(isEven){
            fillArray(result, n, 0);
        } else{
            fillArray(result, n, 1);
        }
        return result;
    }
    private void fillArray(int[] result, int n, int index){
        for(int i=1;i<=n/2;i++){
                result[index++] = i;
                result[index++] = -i;
        }
    }
}