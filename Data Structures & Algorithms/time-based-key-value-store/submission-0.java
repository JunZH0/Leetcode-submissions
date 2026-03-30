class TimeMap {

     private static class Pair {
        int time;
        String value;

        public Pair(int time, String value) {
            this.time = time;
            this.value = value;
        }

        public int getTime() {
            return time;
        }

        public String getValue() {
            return value;
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
        List<Pair> list = map.get(key);

        if (list == null) {
            return "";
        }

        String res = "";

        int l = 0, r = list.size() - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (list.get(m).time <= timestamp) {
                res = list.get(m).value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;

    }   
}
