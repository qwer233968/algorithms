package algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put
 */
public class LRUCache {

    class LinkNode{
        int key;
        int value;
        LinkNode prev;
        LinkNode next;
        public LinkNode(){}
        public LinkNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    int capacity;
    int size = 0;
    Map<Integer,LinkNode> map;
    LinkNode head = new LinkNode();
    LinkNode end = new LinkNode();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head.next = end;
        end.prev = head;
    }

    public int get(int key) {
        LinkNode node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkNode node = map.get(key);
        if (node == null){
            LinkNode newNode = new LinkNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity){
                LinkNode r = removeEnd();
                map.remove(r.key);
                --size;
            }
        }else{
            node.value=value;
            moveToHead(node);
        }
    }

    public void moveToHead(LinkNode node){
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(LinkNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(LinkNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public LinkNode removeEnd(){
        LinkNode r = end.prev;
        removeNode(end.prev);
        return r;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));// 返回  1

        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
