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


    // maybe start doing this later, idk tho
    @Override
    public void clear() {
        TreeNode<K,V> current = root.getLeft();
        TreeNode<K,V> next = null;

        while (current != null) {
            next = current.getLeft();
            current = null;
        }

        root = null;
        size = 0;
        maxDepth = 0;
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
                current = current.getLeft();
            } else {
                parent = nodeStack.pop();
                current = parent.getRight();
                if (parent.getKey().compareTo(itemKey) == 0) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size() ) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        // these variables change when they get handled in the inOrderTraversal recursive method call process
        Pair<K,V>[] result = new Pair[1];
        int[] currentIndex = {0};
        
        root.inOrderTraversal(root, index, currentIndex, result);
        return result[0];
    }

    @Override
    public int findIndex(Predicate<V> searcher) {
        int[] currentIndex = {0};
        return inOrderFindIndex(root, searcher, currentIndex);
    }

    private int inOrderFindIndex(TreeNode<K, V> currentNode, Predicate<V> searcher, int[] currentIndex) {
        if (currentNode == null) {
            return -1;
        }

        int resultLeft = inOrderFindIndex(currentNode.getLeft(), searcher, currentIndex);
        if (resultLeft != -1) {
            return resultLeft;
        }

        if (searcher.test(currentNode.getValue())) {
            return currentIndex[0];
        }
        currentIndex[0]++;

        int resultRight = inOrderFindIndex(currentNode.getRight(), searcher, currentIndex);
        return resultRight;
    }

    // NO NEED TO IMPLEMENT (POSSIBLY) IF VISITOR ISNT USED IN METHODS
    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}
