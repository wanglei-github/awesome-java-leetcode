package self;

class LRUCache {
    private int max;
    private int currentSize = 0;

    private Entry head;
    private Entry tail;

    public LRUCache(int capacity) {
        this.max = capacity;
    }


    public int get(int key) {
        Entry cur = head;
        if (cur == null)
            return -1;
        Entry pre = null;

        while (cur != null && cur.key != key) {
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) {
            return -1;
        }

        //保存前节点和后节点链接
        Entry tmp = cur.next;
        pre.next = tmp;
        //找到后放入头节点
        cur.next = head;
        head = cur;


        setTail();
        return cur.value;
    }

    public void setTail() {
        Entry cur = head;
        Entry pre = null;
        while (cur != null) {
            pre = cur;
            cur = cur.next;

        }
        tail = pre;
    }

    public void remove() {

        Entry cur = head;
        while (cur.next != null) {
            if (cur.next.key == tail.key) {
                tail = cur;
                cur.next = null;
            }
        }


        currentSize--;

    }

    public void put(int key, int value) {

        if (currentSize == max) {
            remove();
        }
        if (head == null) { //首次插入
            head = new Entry(key, value);
            tail = head;
            currentSize++;
            return;
        }

        Entry next = new Entry(key, value);
        Entry tmp = head;
        head = next;
        head.next = tmp;

        currentSize++;

    }

    class Entry {
        Entry next;

        private int key;
        private int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}