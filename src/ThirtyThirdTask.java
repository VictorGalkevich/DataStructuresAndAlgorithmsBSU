import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;

public class ThirtyThirdTask {
    private static final Long MAX = Long.MAX_VALUE;
    private static Node MIN = new Node();
    private static Node ROOT = null;
    private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        while (scanner.hasNext()) {
            insert(scanner.nextLong());
        }
        MIN.length = 0;
        MIN.min = MAX;
        calculate(ROOT);
        cut(ROOT);
        preOrderTraversal(ROOT);
        FileWriter writer = new FileWriter("output.txt");
        writer.write(builder.toString().trim());
        writer.flush();
        writer.close();
    }

    public static void cut(Node node) {
        if (MIN.length % 2 == 1) {
            return;
        } else {
            Node[] arr = new Node[(int) MIN.length + 1];
            arr[arr.length - 1] = MIN;
            int index = arr.length - 2;
            Node current = MIN.left;
            while (current != null) {
                arr[index--] = current;
                if (current.min < current.val) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            current = MIN.right;
            while (current != null) {
                arr[index--] = current;
                if (current.min < current.val) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            Arrays.sort(arr, Comparator.comparingLong(x -> x.val));
            Node toD = arr[(int) (MIN.length / 2)];
            delete(toD.val, node);
        }
    }

    public static void calculate(Node root) {
        if (root == null) {
            return;
        }

        Deque<Node> stack = new ArrayDeque<>();
        Deque<Node> resultStack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            resultStack.push(node);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        while (!resultStack.isEmpty()) {
            Node node = resultStack.pop();

            if (node.left != null) {
                node.sum += node.left.min;
                node.length += 1 + node.left.height;
                node.height = node.left.height + 1;
            }
            if (node.right != null) {
                node.sum += node.right.min;
                node.length += 1 + node.right.height;
                node.height = Math.max(node.height, node.right.height + 1);
            }
            if (node.right == null || node.left == null) {
                node.sum += node.val;
            }
            if (node.right == null && node.left == null) {
                node.min = node.val;
            } else {
                if (node.left == null) {
                    node.min = node.right.min;
                } else if (node.right == null) {
                    node.min = node.left.min;
                } else if (node.left.height > node.right.height) {
                    node.min = node.left.min;
                } else if (node.right.height > node.left.height) {
                    node.min = node.right.min;
                } else {
                    node.min = Math.min(node.left.min, node.right.min);
                }
            }
            if (node.length > MIN.length || (node.length == MIN.length && node.min < MIN.min)) {
                MIN = node;
            }
        }
    }

    public static void delete(long key, Node root) {
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
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else {
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
        ROOT = root;
    }

    public static Node getSuccessor(Node node) {
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

    public static void insert(long key) {
        Node newNode = new Node();
        newNode.val = key;
        newNode.min = key;
        newNode.height = 0;
        if (ROOT == null) {
            ROOT = newNode;
        } else {
            Node currentNode = ROOT;
            while (true) {
                if (key < currentNode.val) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            builder.append(current.val).append("\n");

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static class Node {
        long val;
        long length;
        long min;
        long sum;
        long height;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "CringeNode[" +
                   "val=" + val +
                   ", left=" + left +
                   ", right=" + right +
                   ']';
        }
    }
}
