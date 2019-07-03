package lesson8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    private List<LinkedList<Entry>> dataRow;
    private int size;
    private int maxSize;

    public HashTableImpl(int maxSize) {
        this.maxSize = maxSize;
        this.dataRow = new ArrayList<>(maxSize);
        for (int i = 0; i < maxSize; i++) {
            dataRow.add(new LinkedList<>());
        }
    }

    private int hashFunc(Item key) {
        return key.hashCode() % this.maxSize;
    }

    @Override
    public boolean put(Item item, Integer cost) {
        if (size == maxSize) {
            return false;
        }

        int rowIndex = hashFunc(item);
        dataRow.get(rowIndex).add(new Entry(item, cost));
        return true;
    }

    @Override
    public Integer get(Item item) {

        int rowIndex = hashFunc(item);
        int index = indexOf(item, rowIndex);
        return index != -1 ? dataRow.get(rowIndex).get(index).value : null;
    }


    @Override
    public boolean remove(Item item) {
        int rowIndex = hashFunc(item);
        int index = indexOf(item, rowIndex);
        if(index != -1){
            dataRow.get(rowIndex).remove(index);
            return true;
        }
        return false;
    }

    private int indexOf(Item item, int rowIndex) {

        int count = 0;
        while(dataRow.get(rowIndex).get(count) != null){
            Entry entry = dataRow.get(rowIndex).get(count);
            if (entry.key.equals(item)) {
                return count;
            }
            count++;
            if (count == dataRow.get(rowIndex).size()){
                return -1;
            }
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
        for (LinkedList<Entry> row: dataRow) {
            for (Entry entry: row) {
                System.out.print("[" + entry.key.getTitle() + ", " + entry.value + "]");
            }
            System.out.println();
        }
    }
}
