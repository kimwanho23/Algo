import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());


        int[] stack = new int[n];
        int size = 0; 

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());

            switch (q) {
                case 1: { // push X
                    int num = Integer.parseInt(st.nextToken());
                    stack[size++] = num;
                    break;
                }
                case 2: { // pop
                    if (size == 0) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(stack[--size]).append('\n');
                    }
                    break;
                }
                case 3: { // size
                    sb.append(size).append('\n');
                    break;
                }
                case 4: { // empty
                    sb.append(size == 0 ? 1 : 0).append('\n');
                    break;
                }
                case 5: { // top
                    if (size == 0) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(stack[size - 1]).append('\n');
                    }
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
