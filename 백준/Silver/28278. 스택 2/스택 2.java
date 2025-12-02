import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int q = Integer.parseInt(st.nextToken());

            if (q == 1){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if (q == 2){
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");;
                } else {
                    sb.append(stack.pop()).append("\n");
                }
            } else if (q == 3){
                sb.append(stack.size()).append("\n");
            } else if (q == 4){
                if (stack.isEmpty()) {
                    sb.append(1).append("\n");;
                } else {
                    sb.append(0).append("\n");;
                }
            } else if (q == 5){
                if (stack.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    Integer pop = stack.pop();
                    sb.append(pop).append("\n");
                    stack.push(pop);
                }
            }
        }
        System.out.println(sb);
    }
}
