import java.util.Deque;
import java.util.LinkedList;

public class LRUCache {

    class Node {
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Deque<Node> cacheMemory = new LinkedList<>();
    int cacheCapacity = 2;

    public static void main(String[] args) {
        LRUCache obj = new LRUCache();
        obj.put(1, 1001);
        obj.put(2, 1002);
        obj.put(3, 1003);
        obj.put(4, 1004);
        obj.put(5, 1005);
        obj.cacheMemory.forEach((e) -> {
            System.out.println("Key: " + e.key + " Value: " + e.val);
        });
        int output = obj.get(2);
        System.out.println(output);
        obj.cacheMemory.forEach((e) -> {
            System.out.println("Key: " + e.key + " Value: " + e.val);
        });
        output = obj.get(4);
        System.out.println(output);
        obj.cacheMemory.forEach((e) -> {
            System.out.println("Key: " + e.key + " Value: " + e.val);
        });
    }

    public void put(int key, int value) {
        if (cacheMemory.size() < cacheCapacity) {
            cacheMemory.addFirst(new Node(key, value));
        } else {
            cacheMemory.removeLast();
            cacheMemory.addFirst(new Node(key, value));
        }
    }

    public int get(int key) {
        int val = -1;
        Node nodeToRemove = null;
        int flag = 0;
        for (Node node : cacheMemory) {
            if (node.key == key) {
                val = node.val;
                flag = 1;
                nodeToRemove = node;
            }
        }
        if (flag == 1) {
            cacheMemory.remove(nodeToRemove);
            cacheMemory.addFirst(nodeToRemove);
        }
        return val;
    }
}
