class DynamicArray {

    int capacity;
    int length;
    int[] arr;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.arr = new int[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
            int[] newArr = new int[capacity];

            System.arraycopy(arr, 0, newArr, 0, length);
            arr = newArr;
        }

        arr[length] = n;
        length++;
    }

    public int popback() {
        if (length > 0) length--;
        return arr[length];
    }

    private void resize() {
        capacity *= 2;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
