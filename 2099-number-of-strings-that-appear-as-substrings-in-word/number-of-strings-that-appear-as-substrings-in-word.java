class Solution {
    public int numOfStrings(String[] patterns, String word) {
        return (int) Arrays.stream(patterns).filter(str -> word.contains(str) == true).count();
    }
}