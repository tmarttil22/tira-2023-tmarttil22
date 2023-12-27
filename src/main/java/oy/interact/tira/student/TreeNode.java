package oy.interact.tira.student;

import oy.interact.tira.util.Pair;

public class TreeNode<K extends Comparable<K>, V> {

    TreeNode(K key, V value) {
        this.keyValue = new Pair<>(key, value);
        this.left = this.right = null;
    }
    
    private K key;
    private V value;

    static int addDepth;

    private int hash = -1;
    Pair<K, V> keyValue;
    TreeNode<K,V> left = null;
    TreeNode<K,V> right = null;
    TreeNode<K,V> parent;

    public boolean insert(K key, V value) {
         if (this.value.equals(value)) {
            this.value = value;
            return false;
        }

        boolean result = false;
        if (this.key.compareTo(key) < 0) {      // add to left branch
            if (left == null) {
                left = new TreeNode<>(key, value);
                addDepth++;
                result = true;
            } else {
                addDepth++;
                result = left.insert(key, value);
            }
        } else {
            if (right == null) {
                right = new TreeNode<>(key, value);
                addDepth++;
                result = true;
            } else {
                addDepth++;
                result = left.insert(key, value);
            }
        }
        return result;
    }

    public V find(K key) {
        V result = null;

        if (this.key.equals(key)) {
            result = value;
        } else if (key.compareTo(this.key) <= 0) {
            if (left != null) {
                result = left.find(key);
            }
        } else {
            if (right != null) {
                result = right.find(key);
            }
        }

        return result;
    }

    public K getKey() {
        return key;
    }

    public TreeNode<K,V> left() {
        return left;
    }

    public TreeNode<K,V> right() {
        return right;
    }


}