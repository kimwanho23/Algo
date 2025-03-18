import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int result;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }


        int size = pq.size();

        for (int i = 0; i < size - 1; i++) {
            int first = pq.poll();
            int second = pq.poll();

            int third = first + second;

            result += third;
            pq.add(third);
        }

        System.out.println(result);
    }
}
