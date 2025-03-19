import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        void insert(int value) {
            if (value < this.value){ // 작으면 왼쪽
                if (this.left == null) {
                    this.left = new Node(value);
                } else this.left.insert(value);
            } else { // 크면 오른쪽
                if (this.right == null) {
                    this.right = new Node(value);
                } else this.right.insert(value);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine())); // 루트 노드
        String input;
        while (true){
            input = br.readLine();
            if (input == null || input.isEmpty()) break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }
    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
