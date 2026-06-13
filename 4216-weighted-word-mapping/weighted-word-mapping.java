class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        for(String str: words){
            int sum = 0;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                sum += weights[ch - 'a'];
            }
            result.append((char) ('z' - (sum %= 26)));
        }
        return result.toString();
    }
}