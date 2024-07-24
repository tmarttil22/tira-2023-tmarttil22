package oy.interact.tira.student;

import java.util.Comparator;

import oy.interact.tira.util.Pair;

public class TreeNode<K extends Comparable<K>, V> {

    TreeNode(K key, V value) {
        this.keyValue = new Pair<>(key, value);
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }

    private K key;
    private V value;

    static int addDepth;

    // private int hash = -1;
    Pair<K, V> keyValue;
    TreeNode<K, V> left = null;
    TreeNode<K, V> right = null;
    TreeNode<K, V> parent;

    public boolean insert(K key, V value, Comparator<K> comparator) {
        if (this.value.equals(value)) {
            this.value = value;
            this.key = key;
            return false;
        }

        boolean result = false;
        if (comparator.compare(this.key, key) > 0) { // add to left branch
            if (left == null) {
                left = new TreeNode<>(key, value);
                addDepth++;
                result = true;
            } else {
                addDepth++;
                result = left.insert(key, value, comparator);
            }
        } else {
            if (right == null) {
                right = new TreeNode<>(key, value);
                addDepth++;
                result = true;
            } else {
                addDepth++;
                result = right.insert(key, value, comparator);
            }
        }
        return result;
    }

    public V find(K key, Comparator<K> comparator) {
        V result = null;

        if (this.key.equals(key)) {
            result = value;
        } else if (comparator.compare(key, this.key) <= 0) {
            if (left != null) {
                result = left.find(key, comparator);
            }
        } else {
            if (right != null) {
                result = right.find(key, comparator);
            }
        }

        return result;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public TreeNode<K, V> getLeft() {
        return left;
    }

    public TreeNode<K, V> getRight() {
        return right;
    }

    public TreeNode<K, V> getParent() {
        return parent;
    }

    public void setKeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
