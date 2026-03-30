class TimeMap {

    private static class Pair {
        int time;
        String value;

        public Pair(int time, String value) {
            this.time = time;
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
        List<Pair> pairs = map.get(key);
        if (pairs == null) return "";
        
        int l = 0, r = pairs.size() - 1;
        String res = "";

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (pairs.get(m).time <= timestamp) {
                res = pairs.get(m).value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
