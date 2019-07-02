package lesson8;

public class HashTableImpl implements HashTable {

    private static class Entry {
        private Item key;
        private int value;

        public Entry(Item key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }


    private Entry[] data;
    private int size;
    private int maxSize;

    public HashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Entry[maxSize * 2];
    }

    private int hashFunc(Item key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(Item item, Integer cost) {
        if (size == maxSize) {
            return false;
        }

        int count = 0;

        int index = hashFunc(item);
        while (data[index] != null) {
            if (data[index].key.equals(item)) {
                data[index].value = cost;
                return true;
            }

            if (count >= data.length) {
                return false;
            }

            index += getStep(item);
            count++;
            index %= data.length;
        }

        data[index] = new Entry(item, cost);
        size++;

        return true;
    }

    protected int getStep(Item item) {
        return 1;
    }

    @Override
    public Integer get(Item item) {
        int index = indexOf(item);
        return index != -1 ? data[index].value : null;
    }


    @Override
    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index != -1) {
            data[index] = null;
            size--;
            return true;
        }

        return false;
    }

    private int indexOf(Item item) {
        int index = hashFunc(item);
        int count = 0;

        while (data[index] != null && count < data.length) {
            Entry entry = data[index];
            if (entry.key.equals(item)) {
                return index;
            }

            index += getStep(item);
            index %= data.length;
            count++;
        }

        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("-----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]", i, data[i]);
            System.out.println();
        }
        System.out.println("-----------");
    }
}
