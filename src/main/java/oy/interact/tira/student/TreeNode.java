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

    //private int hash = -1;
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



    // ChatGPT utilized, prompt used "how would i do a getIndex method for a binary search tree recursively", modified to account for already written methods and variable names
    public void inOrderTraversal(TreeNode<K, V> currentNode, int targetIndex, int[] currentIndex, Pair<K, V>[] result) {
        if (currentNode == null || currentIndex[0] >= targetIndex) {
            return;
        }
        inOrderTraversal(currentNode.getLeft(), targetIndex, currentIndex, result);

        currentIndex[0]++;
        if (currentIndex[0] == targetIndex) {
            result[0] = new Pair<K, V>(currentNode.getKey(), currentNode.getValue());
            return;
        }
        inOrderTraversal(currentNode.getRight(), targetIndex, currentIndex, result);
    }



    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public TreeNode<K,V> getLeft() {
        return left;
    }

    public TreeNode<K,V> getRight() {
        return right;
    }

    public TreeNode<K,V> getParent() {
        return parent;
    }

    public void setKeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

}