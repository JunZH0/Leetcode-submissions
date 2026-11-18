class RandomizedSet {

    private Map<Integer, Integer> mapSet;
    private List<Integer> list;
    private Random rd;

    public RandomizedSet() {
        this.mapSet = new HashMap<>();
        this.list = new ArrayList<>();
        this.rd = new Random();
    }
    
    public boolean insert(int val) {
        if (mapSet.containsKey(val)) {
            return false;
        }

        mapSet.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!mapSet.containsKey(val)) {
            return false; 
        }

        int last = list.get(list.size() - 1);
        int idx = mapSet.get(val);

        list.set(idx, last);
        mapSet.put(last, idx);
        list.remove(list.size() - 1);
        mapSet.remove(val);

        return true;
        
    }
    
    public int getRandom() {
        return list.get(rd.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */