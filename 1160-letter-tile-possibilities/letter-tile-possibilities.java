class Solution {
    Set<String> set;
    public int numTilePossibilities(String tiles) {
        set = new TreeSet<>();
        solve(tiles, new StringBuilder());
        // System.out.println(set);
        return set.size();
    }
    private void solve(String tiles, StringBuilder str){
        if(tiles.length() == 1){
            str.append(tiles);
            set.add(str.toString());
            str.setLength(str.length() - 1);
            return;
        }
        for(int i=0;i<tiles.length();i++){
            str.append(tiles.substring(i, i+1));
            set.add(str.toString());
            String substring = getSubstring(tiles, i);
            solve(substring, str);
            str.setLength(str.length() - 1);
        }
    }
    private String getSubstring(String str, int index){
        if(index == 0){
            return str.substring(index+1);
        } else if(index == str.length() - 1){
            return str.substring(0, index);
        } else{
            return str.substring(0, index) + str.substring(index+1);
        }
    }
}