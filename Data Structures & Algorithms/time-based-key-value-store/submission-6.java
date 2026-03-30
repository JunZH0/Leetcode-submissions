class TimeMap {

    private class Pair {
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(timestamp, value);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(pair);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        
        List<Pair> pairs = map.get(key);
        String res = "";
        int l = 0, r = pairs.size() - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            Pair currP = pairs.get(m);

            if(currP.timestamp <= timestamp) {
                res = currP.value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
