class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        char[] even1 = getChars(s1, 0);
        char[] even2 = getChars(s2, 0);
        char[] odd1 = getChars(s1, 1);
        // System.out.println(Arrays.toString(even1));
        char[] odd2 = getChars(s2, 1);
        // System.out.println(Arrays.toString(even2));
        return (Arrays.equals(even1, even2) && Arrays.equals(odd1, odd2));
    }

    private char[] getChars(String str, int start){
        int n = str.length();
        char[] chars = new char[(int)Math.ceil(n/2.0)];
        int index=0;
        for(int i=start;i<n;i+=2){
            chars[index++] = str.charAt(i);
        }
        Arrays.sort(chars);
        return chars;
    }
}