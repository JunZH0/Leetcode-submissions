class MedianFinder {

    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        int size = minHeap.size() + maxHeap.size();
        if (size % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } 

        return minHeap.peek();
    }
}
