class Solution {
    private static final String reference = "abc";
    private List<String> list;
    public String getHappyString(int n, int k) {
        list = new ArrayList<>();
        for(int i=0;i<3;i++){
            char ch = reference.charAt(i);
            solve(reference.substring(i, i+1), getSubstring(ch), n);
        }
        System.out.println(list);
        return k<=list.size() ? list.get(k-1) : "";
    }
    private void solve(String str, String newReferenceString,  int n){
        if(str.length() == n){
            list.add(str);
            return;
        }
        for(int i=0;i<newReferenceString.length();i++){
            char ch = newReferenceString.charAt(i);
            solve(str + ch, getSubstring(ch), n);
        }
    }
    private String getSubstring(char ch){
        String substring = "";
        for(int i=0;i<3;i++){
            if(reference.charAt(i) != ch){
                substring += reference.charAt(i);
            }
        }
        return substring;
    }
}