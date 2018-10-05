package custommap;

public class HashMap {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int size = 0;
    private Integer[] keys = new Integer[DEFAULT_CAPACITY];
    private long[] values = new long[DEFAULT_CAPACITY];



    public void put(int key, long value) {
        if (size > keys.length * LOAD_FACTOR) {
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

        while (isPositionTaken(position)) {
            position++;
        }

        keys[position] = key;
        values[position] = value;
        size++;
    }

    private boolean isPositionTaken(int position) {
        if (keys[position] != null) {
            return true;
        }

        return false;
    }

    private int searchKeyPosition (int key) {
        int position = calculatePosition(key);

        return keys[position];
    }

    private int calculatePosition(int key) {
        return key & (keys.length - 1);
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
