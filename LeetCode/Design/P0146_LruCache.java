package LeetCode.Design;

/**
 * Platform: LeetCode
 * Problem ID: 146
 * Problem Name: LRU_CACHE
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/lru_cache/
 * 
 * Complexity:
 * - Time Complexity: O(1)
 * - Space Complexity: O(capacity)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0146_LruCache {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0146_LruCache...");
    }

    // TODO: Write solution method here
}
class LRUCache {
    class Node
    {
        Node prev;
        Node next;
        int key;
        int value;
        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head  = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }

        Node temp = map.get(key);
        removeFromDLL(temp);

        addToFront(temp);
        return temp.value;
    }

    public void put(int key, int value) {
        Node temp = null;
        if(map.containsKey(key))
        {
            temp = map.get(key);
            temp.value = value;
            removeFromDLL(temp);
        }
        else
        {
            temp = new Node(key, value);
            map.put(key, temp);
        }

        //put at the front
        addToFront(temp);

        if(map.size() <= capacity)
        {
            return;
        }
        //cache is full
        Node toBeRemoved = tail.prev;
        if(map.containsKey(toBeRemoved.key))
        {
            map.remove(toBeRemoved.key);
        }
        //remove from DLL
        removeFromDLL(toBeRemoved);


    }
    void addToFront(Node temp)
    {
        Node nextHead = head.next;

        head.next = temp;
        temp.prev = head;

        temp.next = nextHead;
        nextHead.prev = temp;

    }
    void removeFromDLL(Node temp)
    {
        Node prevNode = temp.prev;
        Node nextNode = temp.next;

        //de-link
        temp.prev = null;
        temp.next = null;

        //merge the gap
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}


