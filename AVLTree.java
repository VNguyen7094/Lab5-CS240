//Name: Viet Trinh Nguyen
//Date: 2/26/25
//CS 240
// Programming AVL tree
public class AVLTree {
        private AVLNode root;
    
        public AVLTree() {
            root = null;
        }
    
        // Get height of the node
        private int height(AVLNode node) {
            return node == null ? 0 : node.height;
        }
    
        // Right Rotation
        private AVLNode rightRotate(AVLNode y) {
            AVLNode x = y.left;
            AVLNode T2 = x.right;
    
            x.right = y;
            y.left = T2;
    
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;
    
            return x;
        }
    
        // Left Rotation
        private AVLNode leftRotate(AVLNode x) {
            AVLNode y = x.right;
            AVLNode T2 = y.left;
    
            y.left = x;
            x.right = T2;
    
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;
    
            return y;
        }
    
        // Get the balance factor of a node
        private int getBalance(AVLNode node) {
            return node == null ? 0 : height(node.left) - height(node.right);
        }
    
        // Insert a new key
        public AVLNode insert(AVLNode node, int key) {
            if (node == null) {
                return new AVLNode(key);
            }
    
            if (key < node.key) {
                node.left = insert(node.left, key);
            } else if (key > node.key) {
                node.right = insert(node.right, key);
            } else {
                return node; // Duplicate keys are not allowed
            }
    
            // Update the height of the ancestor node
            node.height = 1 + Math.max(height(node.left), height(node.right));
    
            // Balance the node if it becomes unbalanced
            int balance = getBalance(node);
    
            // Left heavy
            if (balance > 1 && key < node.left.key) {
                return rightRotate(node);
            }
    
            // Right heavy
            if (balance < -1 && key > node.right.key) {
                return leftRotate(node);
            }
    
            // Left-right heavy
            if (balance > 1 && key > node.left.key) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
    
            // Right-left heavy
            if (balance < -1 && key < node.right.key) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
    
            return node;
        }
    
        // Wrapper method to insert into the tree
        public void insert(int key) {
            root = insert(root, key);
        }
    
        // Inorder traversal
        public void inorder(AVLNode node) {
            if (node != null) {
                inorder(node.left);
                System.out.print(node.key + " ");
                inorder(node.right);
            }
        }
    
        // Wrapper for inorder traversal
        public void inorder() {
            inorder(root);
            System.out.println();
        }
    
        // Preorder traversal (root, left, right)
        public void preorder(AVLNode node) {
            if (node != null) {
                System.out.print(node.key + " ");
                preorder(node.left);
                preorder(node.right);
            }
        }
    
        // Wrapper for preorder traversal
        public void preorder() {
            preorder(root);
            System.out.println();
        }
    
        // Postorder traversal (left, right, root)
        public void postorder(AVLNode node) {
            if (node != null) {
                postorder(node.left);
                postorder(node.right);
                System.out.print(node.key + " ");
            }
        }
    
        // Wrapper for postorder traversal
        public void postorder() {
            postorder(root);
            System.out.println();
        }
    
    
    
    }
    
