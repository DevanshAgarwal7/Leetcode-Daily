class NumberContainers {
    Map<Integer, TreeSet<Integer>> map;
    Map<Integer, Integer> indexMap;
    public NumberContainers() {
        map = new HashMap<>();
        indexMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(map.containsKey(number)){
            TreeSet<Integer> treeSet = map.get(number);
            if(!treeSet.contains(index)){
                treeSet.add(index);
            }
            map.put(number, treeSet);
            if(indexMap.containsKey(index) && indexMap.get(index) != number){
                int oldNumber = indexMap.get(index);
                TreeSet<Integer> treeSetOldNumber = map.get(oldNumber);
                treeSetOldNumber.remove(index);
            }
            indexMap.put(index, number);
        } else{
            if(indexMap.containsKey(index)){
                int previousNumber = indexMap.get(index);
                TreeSet<Integer> treeSet = map.get(previousNumber);
                treeSet.remove(index);
            }
            TreeSet<Integer> treeSet = new TreeSet<>();
            treeSet.add(index);
            map.put(number, treeSet);
            indexMap.put(index, number);
        }
    }
    
    public int find(int number) {
        if(map.containsKey(number)){
            return map.get(number).size() > 0 ? map.get(number).first() : -1 ;
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */