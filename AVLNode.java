//Name: Viet Trinh Nguyen
//Date: 2/26/25
//CS 240
// Programming AVL tree
public class AVLNode {
    int key;
    int height;
    AVLNode left, right;

    public AVLNode(int key) {
        this.key = key;
        this.height = 1;
        this.left = this.right = null;
    }
}


