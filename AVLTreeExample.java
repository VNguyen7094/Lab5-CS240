//Name: Viet Trinh Nguyen
//Date: 2/26/25
//CS 240
// Programming AVL tree
public class AVLTreeExample {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert nodes into the AVL tree
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(70);
        tree.insert(50);
        tree.insert(60);

        // Print tree traversals
        System.out.println("Inorder Traversal:");
        tree.inorder();

        System.out.println("Preorder Traversal:");
        tree.preorder();

        System.out.println("Postorder Traversal:");
        tree.postorder();
    }
}
