import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BinarySearchTree {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);
            BinaryTree binaryTree = new BinaryTree();
            int delete = scanner.nextInt();
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                int key = Integer.parseInt(scanner.nextLine());
                binaryTree.insert(key);
            }
            binaryTree.delete(delete);
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            binaryTree.preOrderTraversal(writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int key) {
            this.val = key;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        Node root;

        public void insert(int key) {
            Node newNode = new Node(key);

            if (root == null) {
                root = newNode;
                return;
            }

            Node current = root;
            Node parent;

            while (true) {
                parent = current;

                if (key < current.val) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else if (key > current.val) {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public void preOrderTraversal(BufferedWriter writer) throws IOException {
            if (root == null) {
                return;
            }

            Stack<Node> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                Node current = stack.pop();
                writer.write(current.val + "\n");

                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }

        public void delete(int key) {
            if (root == null) {
                return;
            }

            Node current = root;
            Node parent = null;
            boolean isLeftChild = false;

            while (current != null && current.val != key) {
                parent = current;

                if (key < current.val) {
                    current = current.left;
                    isLeftChild = true;
                } else {
                    current = current.right;
                    isLeftChild = false;
                }
            }

            if (current == null) {
                return;
            }
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
            else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else if (isLeftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            }
            else {
                Node successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
                successor.left = current.left;
            }
        }

        private Node getSuccessor(Node node) {
            Node successor = node;
            Node successorParent = node;
            Node current = node.right;

            while (current != null) {
                successorParent = successor;
                successor = current;
                current = current.left;
            }

            if (successor != node.right) {
                successorParent.left = successor.right;
                successor.right = node.right;
            }

            return successor;
        }
    }
}