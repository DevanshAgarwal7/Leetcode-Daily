class Solution {
    public String digitSum(String s, int k) {
        int length = s.length();
        while(length > k){
            StringBuilder str = new StringBuilder();
            for(int i=0;i<length;i+=k){
                int sum = 0;
                for(int j=i;j<Math.min(i+k, length);j++){
                    sum += (s.charAt(j) - '0');
                }
                str.append(sum);
            }
            s = str.toString();
            length = s.length();
        }
        return s;
    }
}