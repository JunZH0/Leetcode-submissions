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
        List<Pair> pair = map.get(key);

        if (pair == null) {
            return "";
        }
 
        int l = 0, r = pair.size() - 1;
        String res = "";

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (pair.get(m).timestamp <= timestamp) {
                res = pair.get(m).value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
