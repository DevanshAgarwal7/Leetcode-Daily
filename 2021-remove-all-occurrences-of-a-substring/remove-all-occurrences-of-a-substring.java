class Solution {
    public String removeOccurrences(String s, String part) {
        //see sashcode YT video
        int n = s.length();
        int m = part.length();
        StringBuilder result = new StringBuilder();
        for(char ch: s.toCharArray()){
            result.append(ch);
            if(result.length() >= m){
                String subString = result.substring(result.length() - m);
                if(subString.equals(part)){
                    result.setLength(result.length() - m);
                }
            } 
        }
        return result.toString();
    }
}