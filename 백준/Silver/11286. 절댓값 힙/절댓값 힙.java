
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minorPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> plusPq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if (m > 0) {
                plusPq.add(m);
            } else if (m < 0) {
                minorPq.add(m);
            } else {
                if (minorPq.isEmpty() && plusPq.isEmpty()) {
                    sb.append(0).append("\n");
                } else if (minorPq.isEmpty()) {
                    sb.append(plusPq.poll()).append("\n");
                } else if (plusPq.isEmpty()) {
                    sb.append(minorPq.poll()).append("\n");
                }
                else {
                    int minorPeek = minorPq.peek();
                    int plusPeek = plusPq.peek();

                    if (Math.abs(minorPeek) < Math.abs(plusPeek)) {
                        sb.append(minorPq.poll()).append("\n");
                    } else if (Math.abs(minorPeek) > Math.abs(plusPeek)) {
                        sb.append(plusPq.poll()).append("\n");
                    } else {
                        sb.append(minorPq.poll()).append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
