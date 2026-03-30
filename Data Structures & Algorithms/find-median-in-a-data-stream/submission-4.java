class MedianFinder {

    private List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }
    
    public double findMedian() {
        if (list.size() % 2 == 0) {
            return (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0;
        }
        return list.get(list.size() / 2);
    }
}
