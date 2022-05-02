package List;
//���������յ����ݽṹ����ƺ�ʵ��һ��? LRU (Least Recently Used���������ʹ��) ������� ��
//ʵ�� LRUCache �ࣺ

//LRUCache(int capacity) ����������Ϊ����?capacity ��ʼ�� LRU ����
//int get(int key) ����ؼ��� key �����ڻ����У��򷵻عؼ��ֵ�ֵ�����򷵻� -1 ��
//void put(int key, int value)?����ؼ����Ѿ����ڣ�����������ֵ������ؼ��ֲ����ڣ��������顸�ؼ���-ֵ���������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ�����δʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // ʹ��αͷ����αβ���ڵ�
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // ��� key ���ڣ���ͨ����ϣ��λ�����Ƶ�ͷ��
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // ��� key �����ڣ�����һ���µĽڵ�
            DLinkedNode newNode = new DLinkedNode(key, value);
            // ��ӽ���ϣ��
            cache.put(key, newNode);
            // �����˫�������ͷ��
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // �������������ɾ��˫�������β���ڵ�
                DLinkedNode tail = removeTail();
                // ɾ����ϣ���ж�Ӧ����
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // ��� key ���ڣ���ͨ����ϣ��λ�����޸� value�����Ƶ�ͷ��
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        System.out.println(cache.get(1));
    }
}

