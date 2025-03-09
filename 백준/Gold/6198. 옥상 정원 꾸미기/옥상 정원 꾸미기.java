import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N개의 빌딩
        Stack<Integer> stack = new Stack<>();

        long count = 0;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= value) {
                stack.pop();
            }
            count += stack.size();
            stack.push(value);
        }
        System.out.println(count);

    }
}
