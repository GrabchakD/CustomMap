package custommap;

public class HashMap {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;
    private Integer[] keys = new Integer[DEFAULT_CAPACITY];
    private long[] values = new long[DEFAULT_CAPACITY];

    public void put(int key, long value) {
        if (size > keys.length/25) {
            resize();
        }

        insertKeyAndValue(key, value);
    }

    public long get(int key) {
        int position = searchKeyPosition(key);
        return values[position];
    }

    public int getSize() {
        return size;
    }

    private void insertKeyAndValue(int key, long value) {
        int position = key & (DEFAULT_CAPACITY - 1);

        while (checkPosition(position)) {
            position++;
        }

        keys[position] = key;
        values[position] = value;
        size++;
    }

    private boolean checkPosition(int position) {
        return keys[position] != null ? false : true;
    }

    private int searchKeyPosition (int key) {
        int position = key & (DEFAULT_CAPACITY - 1);

        return keys[position];
    }

    private void resize() {
        int newCapacity = keys.length * 2;
        Integer[] newKeys = new Integer[newCapacity];
        long[] newValues = new long[newCapacity];
        transferKeys(newKeys);
        transferValues(newValues);
    }

    private void transferKeys(Integer[] newKeys) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                int newPosition = keys[i] & (newKeys.length - 1);
                newKeys[newPosition] = keys[i];
                keys = newKeys;
            }
        }
    }

    private void transferValues(long[] newValues) {
        for (int i = 0; i < values.length; i++) {
            if (keys[i] != null) {
                int newPosition = keys[i] & (newValues.length - 1);
                newValues[newPosition] = values[i];
                values = newValues;
            }
        }
    }
}
