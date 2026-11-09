package IsBSTcheck;

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
}

public class IsBSTcheck {

    private Integer temp = null;

    public boolean checkBST(Node root) {
        if (root != null) {
            if (!checkBST(root.left)) {
                return false;
            }
            if (temp != null && root.data <= temp) {
                return false;
            }
            temp = root.data;
            if (!checkBST(root.right)) {
                return false;
            }
        }
        return true;
    }


    private List<Integer> values = new ArrayList<>();
    private int count = 0;

    private void buildInOrder(Node root, int levels) {
        if (root == null) return;

        if (levels > 0) {
            root.left = new Node();
            buildInOrder(root.left, levels - 1);
        }

        root.data = values.get(count);
        count++;

        if (levels > 0) {
            root.right = new Node();
            buildInOrder(root.right, levels - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = scanner.nextInt();

        IsBSTcheck sol = new IsBSTcheck();
        while (scanner.hasNextInt()) {
            sol.values.add(scanner.nextInt());
        }
        scanner.close();

        Node root = new Node();
        sol.buildInOrder(root, height);

        sol.temp = null;
        System.out.print(sol.checkBST(root) ? "Yes" : "No");
    }
}
