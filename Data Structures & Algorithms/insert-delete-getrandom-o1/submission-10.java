class RandomizedSet {
    
    private Map<Integer, Integer> indexMap;
    private List<Integer> nums;
    private Random rd;


    public RandomizedSet() {
        indexMap = new HashMap<>();
        nums = new ArrayList<>();
        rd = new Random();
    }
    
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) return true;
 
        nums.add(val);
        indexMap.put(val, nums.size() - 1);
        

        return false;
    }
    
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) return false;

        int idx = indexMap.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(idx, last);
        indexMap.put(last, idx);
        nums.remove(nums.size() - 1);
        indexMap.remove(val);

        return true;

    }
    
    public int getRandom() {
        return nums.get(rd.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */