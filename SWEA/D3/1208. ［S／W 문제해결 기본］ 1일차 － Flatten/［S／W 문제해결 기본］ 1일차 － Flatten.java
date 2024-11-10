import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution
{
        static PriorityQueue<Integer> minQ;
    static PriorityQueue<Integer> maxQ;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine()); // 덤핑 횟수

            minQ = new PriorityQueue<>();
            maxQ = new PriorityQueue<>(Comparator.reverseOrder()); // 큰 수가 우선순위를 가진다.

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
               int number = Integer.parseInt(st.nextToken());
               minQ.offer(number);
               maxQ.offer(number);
            }

            for (int i = 0; i < n; i++) {
                // 최솟값과 최댓값을 추출
                int min = minQ.remove();
                int max = maxQ.remove();

                // 최솟값에 1을 더하고, 최댓값에 1을 빼서 다시 힙에 넣음
                minQ.offer(min + 1);
                maxQ.offer(max - 1);
            }
            result = maxQ.remove() - minQ.remove();
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}