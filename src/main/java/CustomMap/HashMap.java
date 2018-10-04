package CustomMap;

public class HashMap<Integer, Long> {

    private int size = 0;
    private int CAPACITY = 16;
    private float LOAD_FACTOR = 0.75f;
    private int THRESHOLD = 14;
    private Entry[] arr = new Entry[CAPACITY];


    public void put(Entry entry) {
        int hash;
        int position;

        if (entry.getKey() == null) {
            putForNullKey(entry);
        }

        hash = entry.getKey().hashCode();
        position = hash & (CAPACITY - 1);

        checkUniqKeyInArr(position, entry);

        searchPosition(position, entry);
    }

    public Entry get(Integer key) {
        int hash;
        int position;
        Entry entry = null;

        if (key == null) {
            return arr[0];
        }

        hash = key.hashCode();
        position = hash & (CAPACITY - 1);

        return entry = searchEntryInArr(position, key);
    }

    public int getSize() {
        return size;
    }

    private void checkUniqKeyInArr(int position, Entry entry) {
        if (arr[position].getKey().hashCode() == entry.getKey().hashCode() && arr[position].getKey().equals(entry.getKey())) {
            arr[position].setValue(entry.getValue());
        }
    }

    private void searchPosition(int position, Entry entry) {
        while (true) {
            if (arr[position] != null) {
                position++;
            } else {
                arr[position] = entry;
                size++;
                break;
            }
        }
    }

    private Entry searchEntryInArr (int position, Integer key) {
        Entry entry = null;

        while (true) {
            if (arr[position].getKey().hashCode() != key.hashCode() && arr[position].getKey().equals(key)) {
                position++;
            } else {
                entry.setKey(key);
                arr[position].setValue(entry.getValue());
                return entry;
            }
        }
    }

    private void putForNullKey (Entry entry) {
        if (arr[0] == null) {
            arr[0] = entry;
        } else {
            searchPosition(1, entry);
        }
    }

    public class Entry<Integer, Long> {

        private Integer key;
        private Long value;

        public Entry() {
        }

        public Entry(Integer key, Long value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Long getValue() {
            return value;
        }

        public void setValue(Long value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
}
