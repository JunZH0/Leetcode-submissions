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
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair> pairs = map.get(key);

        int l = 0, r = pairs.size() - 1;
        String res = "";

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (pairs.get(m).timestamp <= timestamp) {
                res = pairs.get(m).value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
