class TimeMap {

    Map<String, List<String[]>> storage;

    public TimeMap() {
        storage = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        storage.computeIfAbsent(key, k -> new ArrayList<>())
        .add(new String[]{value, Integer.toString(timestamp)});
    }
    
    public String get(String key, int timestamp) {
        if (!storage.containsKey(key)) {
            return "";
        }

        List<String[]> timestamps = storage.get(key);
        int l = 0, r = timestamps.size() - 1;
        String res = "";
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (Integer.parseInt(timestamps.get(m)[1]) > timestamp) {
                r = m - 1;
            } else {
                res = timestamps.get(m)[0];
                l = m + 1;
            }
        }

        return res;
    }
}
