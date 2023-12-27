package oy.interact.tira.student;

import java.util.Comparator;
import java.util.function.Predicate;
import java.lang.Math;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import oy.interact.tira.util.Visitor;

public class BinarySearchTreeContainer<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {



    TreeNode<K, V> root;
    int size;				 // Number of elements currently in the tree.
    int maxDepth;

	private Comparator<K> comparator;  // The comparator used to determine if new node will go to left or right subtree.

	public BinarySearchTreeContainer(Comparator<K> comparator) {
		this.comparator = comparator;
        root = null;
	}



    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (root == null) {
            root = new TreeNode(key, value);
            size++;
            maxDepth = 1;
        } else {
            TreeNode.addDepth = 1;
            if (root.insert(key, value)) {      // if this creates a new node (returns true), increase size
                maxDepth = Math.max(TreeNode.addDepth, maxDepth);
                size++;
            }
        }

    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        if (root == null) {
            return null;
        }
        return root.find(key);
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'capacity'");
    }

    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ensureCapacity'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public Pair<K, V>[] toArray() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

    @Override
    public int indexOf(K itemKey) {
        if (root == null) {
            return -1;
        }
        int index = 0;
        StackImplementation<TreeNode<K, V>> nodeStack = new StackImplementation();
        TreeNode<K, V> current = root;
        TreeNode<K, V> parent = null;

        while (!nodeStack.isEmpty() || current != null) {
            if (current != null) {
                nodeStack.push(current);
                parent = current;
                current = current.left();
            } else {
                parent = nodeStack.pop();
                current = parent.right();
                if (parent.getKey().compareTo(itemKey) == 0) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIndex'");
    }

    @Override
    public int findIndex(Predicate<V> searcher) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findIndex'");
    }

    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
    
}
