package custommap;

public class HashMap {

    private int key;
    private long value;
    private int size = 0;
    private int CAPACITY = 16;
    private int[] keyArr = new int[CAPACITY];
    private long[] valueArr = new long[CAPACITY];

    public void put(int key, long value) {
        if (size > keyArr.length/25) {
            resize(CAPACITY);
        }

        insertKeyAndValue(key, value);
    }

    public long get(int key) {
        int position = searchKeyPosition(key);
        return valueArr[position];
    }

    public int getSize() {
        return size;
    }

    private void insertKeyAndValue(int key, long value) {
        int position = key & (CAPACITY - 1);

        keyArr[position] = key;
        valueArr[position] = value;
        size++;
    }

    private int searchKeyPosition (int key) {
        int position = key & (CAPACITY - 1);

        return keyArr[position];
    }

    private void resize(int CAPACITY) {
        int newCapacity = CAPACITY * 2;
        int[] newKeyArr = new int[newCapacity];
        long[] newValueArr = new long[newCapacity];
        transferKey(newKeyArr, newCapacity);
        transferValue(newValueArr, newCapacity);
    }

    private void transferKey(int[] newKeyArr, int newCapacity) {
        for (int i = 0; i < keyArr.length; i++) {
            if (keyArr[i] != 0) {
                int newPosition = keyArr[i] & (newCapacity - 1);
                newKeyArr[newPosition] = keyArr[i];
            }
        }
    }

    private void transferValue(long[] newValueArr, int newCapacity) {
        for (int i = 0; i < valueArr.length; i++) {
            if (keyArr[i] != 0) {
                int newPosition = keyArr[i] & (newCapacity - 1);
                newValueArr[newPosition] = valueArr[i];
            }
        }
    }
}
