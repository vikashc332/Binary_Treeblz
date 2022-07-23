
public class BinaryTree<K extends Comparable<K>> {

    private Node<K> root;

    /* created function to add values
    Adding values recursively to the binary tree
     */
    private Node<K> addRecursively(Node<K> current, K key) {

        if (current == null) {
            return new Node<K>(key);
        }
        int compareResult = key.compareTo(current.key);

        if (compareResult == 0)
            return current;
        if (compareResult < 0)
            current.left = addRecursively(current.left, key);
        else
            current.right = addRecursively(current.right, key);

        return current;

    }

    public void add(K key) {
        this.root = this.addRecursively(root, key);
    }

    /*Created Search function
    * For Search a Value in the Binary Tree */
    private boolean searchTreeRecursively(Node<K> current, K key) {
        if (current == null) {
            return false;
        }
        int compareResult = key.compareTo(current.key);
        if (compareResult == 0) {
            return true;
        }
        return compareResult < 0 ? searchTreeRecursively(current.left, key) : searchTreeRecursively(current.right, key);
    }

    public boolean searchTree(K key) {
        return searchTreeRecursively(root, key);
    }

    private int getSizeRecursively(Node<K> current) {
        return current == null ? 0 : 1 + this.getSizeRecursively(current.left) + this.getSizeRecursively(current.right);
    }

    public int getSize() {
        return this.getSizeRecursively(root);
    }

    //Created function for Print the Binary Tree
    public void printBinaryTree() {
        System.out.println("My Tree: " + root);
    }

    @Override
    public String toString() {
        return "MyBinaryTree{" + root + '}';
    }
}
