class MedianFinder {

    private Queue<Integer> low;
    private Queue<Integer> high;

    public MedianFinder() {
        low = new PriorityQueue<>(Comparator.reverseOrder());
        high = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        low.offer(num);

        high.offer(low.poll());

        if (low.size() < high.size()) {
            low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        }

        return (low.peek() + high.peek()) / 2.0;
    }
}
