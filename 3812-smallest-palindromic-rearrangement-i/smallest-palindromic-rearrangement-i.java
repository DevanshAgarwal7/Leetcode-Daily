class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n <= 1){
            return s;
        }
        int half = (int) Math.ceil(n/2);
        String str = s.substring(0, half);
        String result = str.chars().sorted().mapToObj(ch -> String.valueOf((char) ch)).collect(Collectors.joining());
        StringBuilder sb = new StringBuilder(result);
        if(n%2 == 1){
            result += s.charAt(n/2);
        }
        return result + sb.reverse().toString();
    }
}