package trees;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Interfaces.BinaryTreeADT;
import Lists.ArrayUnorderedList;
import Nodes.BinaryTreeNode;
import Queues.LinkedQueue;

import java.util.Iterator;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
    protected int count;
    protected BinaryTreeNode<T> root;

    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTree(){
        count = 0;
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element  the element that will become the root of the
     * new binary tree
     */
    public LinkedBinaryTree (T element) {
        count = 1;
        root = new BinaryTreeNode<T> (element);
    }

    @Override
    public T getRoot() {
        return this.root.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inorder (root, tempList);
        return tempList.iterator();
    }
    /**
     * Performs a recursive inorder traversal.
     *
     * @param node the node to be used as the root
     * for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inorder (BinaryTreeNode<T> node,
                            ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inorder(node.getLeft(), tempList);
            tempList.addToRear(node.getElement());
            inorder(node.getRight(), tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        preOrder(root, tempList);
        return tempList.iterator();
    }

    /**
     * Performs a recursive Preorder traversal.
     *
     * @param node the node to be used as the root
     * for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void preOrder (BinaryTreeNode<T> node,
                            ArrayUnorderedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.getElement());
            inorder(node.getLeft(), tempList);
            inorder(node.getRight(), tempList);
        }
    }



    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        PostOrder(root, tempList);
        return tempList.iterator();
    }
    /**
     * Performs a recursive Preorder traversal.
     *-
     * @param node the node to be used as the root
     * for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void PostOrder(BinaryTreeNode<T> node,
                             ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inorder(node.getLeft(), tempList);
            inorder(node.getRight(), tempList);
            tempList.addToRear(node.getElement());
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        LinkedQueue<BinaryTreeNode<T>> nodes = new LinkedQueue<>();
        ArrayUnorderedList<T> results = new ArrayUnorderedList<>();
        nodes.enqueue(this.root);

        while(!nodes.isEmpty()){
            try {
                BinaryTreeNode<T> current = nodes.dequeue();
                if(current != null){
                    nodes.enqueue(current.getLeft());
                    nodes.enqueue(current.getRight());
                    results.addToRear(current.getElement());
                }
            } catch ( EmptyCollectionException ex) {}
        }

        return results.iterator();
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        return null;
    }

    @Override
    public boolean contains(T targetElement) {
        return false;
    }
}
