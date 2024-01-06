package oy.interact.tira.student;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
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


    @SuppressWarnings ("unchecked")
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
        int[] currentIndex = {0};
        return inOrderFind(root, searcher, currentIndex);
    }



    // essentially the same method as inOrderFindIndex, except returns type V
    private V inOrderFind(TreeNode<K, V> currentNode, Predicate<V> searcher, int[] currentIndex) {
        if (currentNode == null) {
            return null;
        }

        V resultLeft = inOrderFind(currentNode.getLeft(), searcher, currentIndex);
        if (resultLeft != null) {
            return resultLeft;
        }
        if (searcher.test(currentNode.getValue())) {
            return currentNode.getValue();
        }
        currentIndex[0]++;
    
        V resultRIght = inOrderFind(currentNode.getRight(), searcher, currentIndex);
        return resultRIght;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return maxDepth;
    }



    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        if (capacity == 0 || capacity < size()) {
            throw new IllegalArgumentException("Provided capacity is invalid");
        }
        if (capacity > capacity()) {
            BinarySearchTreeContainer<K, V> newTree = new BinarySearchTreeContainer<>(comparator);

            treeElementTransfer(root, newTree);

            this.root = newTree.root;
            this.maxDepth = newTree.maxDepth;
        }
        // if capacity < maxDepth, capacity is already ensured
    }

    private void treeElementTransfer(TreeNode<K, V> originalRoot, BinarySearchTreeContainer<K, V> newTree) {
        if (originalRoot != null) {
            newTree.add(originalRoot.getKey(), originalRoot.getValue());
            treeElementTransfer(originalRoot.getLeft(), newTree);           // recursive loop for copying all elements to new tree
            treeElementTransfer(originalRoot.getRight(), newTree);
        }
    }



    @Override
    public void clear() {
        clearTree(root);

        root = null;
        size = 0;
        maxDepth = 0;
    }

    private void clearTree(TreeNode<K, V> node) {
        if (node != null) {
            clearTree(node.getLeft());
            clearTree(node.getRight());
            node.setKeyValue(null, null);
        }
    }


    @SuppressWarnings ("unchecked")
    @Override
    public Pair<K, V>[] toArray() throws Exception {
        Pair<K, V>[] result = new Pair[size()];
        int[] currentIndex = {0};

        inOrderToArray(root, result, currentIndex);
        return result;
    }

    private void inOrderToArray(TreeNode<K, V> currentNode, Pair<K, V>[] array, int[] currentIndex) {
        if (currentNode != null) {
            inOrderToArray(currentNode.getLeft(), array, currentIndex);
    
            array[currentIndex[0]++] = new Pair<>(currentNode.getKey(), currentNode.getValue());
    
            inOrderToArray(currentNode.getRight(), array, currentIndex);
        }
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
        AtomicInteger currentIndex = new AtomicInteger(-1);     // initial value of -1, because before the first value gets looked at in the inOrderTraversal if-statement, 1 gets added to it (this takes care of index 0)
        
        inOrderTraversal(root, index, currentIndex, result);
        return result[0];
    }

    // ChatGPT utilized, prompt used "how would i do a getIndex method for a binary search tree recursively", modified to account for already written methods and variable names and changed to work with AtomicInteger
    public void inOrderTraversal(TreeNode<K, V> currentNode, int targetIndex, AtomicInteger currentIndex, Pair<K, V>[] result) {
        if (currentNode == null || currentIndex.get() > targetIndex) {
            return;
        }
        inOrderTraversal(currentNode.getLeft(), targetIndex, currentIndex, result);

        currentIndex.incrementAndGet();
        if (currentIndex.get() == targetIndex) {
            result[0] = new Pair<K, V>(currentNode.getKey(), currentNode.getValue());
            return;
        }
        inOrderTraversal(currentNode.getRight(), targetIndex, currentIndex, result);
    }


    
    @Override
    public int findIndex(Predicate<V> searcher) {
        int[] currentIndex = {0};
        return inOrderFindIndex(root, searcher, currentIndex);
    }

    // idea for using a  helper method obtained from chatGPT, prompting the class's own description and asking for an example code, modified to use TreeNode class methods
    private int inOrderFindIndex(TreeNode<K, V> currentNode, Predicate<V> searcher, int[] currentIndex) {
        if (currentNode == null) {
            return -1;
        }

        int resultLeft = inOrderFindIndex(currentNode.getLeft(), searcher, currentIndex);
        if (resultLeft != -1) {
            return resultLeft;
        }

        if (searcher.test(currentNode.getValue())) {        // test if the observed value has the searchers value within it
            return currentIndex[0];                         // if so, return the index to the original method
        }
        currentIndex[0]++;

        int resultRight = inOrderFindIndex(currentNode.getRight(), searcher, currentIndex);
        return resultRight;
    }



    
    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {
        visitor.visit(this);
        inOrderAccept(root, visitor);
    }

    private void inOrderAccept(TreeNode<K, V> currentNode, Visitor<K, V> visitor) {
        if (currentNode != null) {
            //currentNode.accept(visitor);
            inOrderAccept(currentNode.getLeft(), visitor);
            inOrderAccept(currentNode.getRight(), visitor);
        }
    }
}
