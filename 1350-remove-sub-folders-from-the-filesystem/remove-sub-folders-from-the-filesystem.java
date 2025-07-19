class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        Set<String> set = new HashSet<>();
        for(String dir: folder){
            String[] dirParts = dir.split("/");
            String parentDir = "";
            boolean isSubDir = false;
            for(int i=1;i<dirParts.length;i++){
                parentDir += "/" + dirParts[i];
                if(set.contains(parentDir)){
                    isSubDir = true;
                    break;
                }
            }
            if(!isSubDir) set.add(parentDir);
        }
        return new ArrayList<>(set);
    }
}