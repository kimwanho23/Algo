import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());

            if (x1 + x2 + x3 == 0){
                break;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(x1);
            pq.add(x2);
            pq.add(x3);

           int one = pq.remove();
           int two = pq.remove();
           int three = pq.remove();

            if (one == two && two == three){
                sb.append("Equilateral").append("\n"); // 정삼
            }
            else if ((one == two || two == three || one == three) && three < one + two){
                sb.append("Isosceles").append("\n"); // 이등변
            } else if (three < one + two){
                sb.append("Scalene").append("\n");
            } else {
                sb.append("Invalid").append("\n");
            }
        }
        System.out.println(sb);

    }
}
