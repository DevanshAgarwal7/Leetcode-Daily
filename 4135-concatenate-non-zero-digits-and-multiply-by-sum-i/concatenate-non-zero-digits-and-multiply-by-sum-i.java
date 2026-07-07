class Solution {
    public long sumAndMultiply(int n) {
        if(n == 0){
            return n;
        }
        String str = String.valueOf(n).replace("0","");
        long x = Long.parseLong(str);
        int sum = str.chars().map(ch -> ch - '0').sum();
        return x * sum;
    }
}