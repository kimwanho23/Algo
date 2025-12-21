import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Balloon {
        int number;
        int value;
        public Balloon(int number, int value) {
            this.number = number;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Balloon> dq = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine()); // N

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(st.nextToken()); // 종이에 적힌 값
            dq.add(new Balloon(i, val));
        }
        Balloon firstBalloon = dq.pollFirst();
        int firstNumber = firstBalloon.number;
        int next = firstBalloon.value;

        sb.append(firstBalloon.number).append(" ");

        while (!dq.isEmpty()) {
            if (next > 0){ // 양수
                for (int i = 0; i < next - 1; i++) {
                    dq.addLast(dq.pollFirst());
                }
                Balloon balloon = dq.pollFirst();
                sb.append(balloon.number).append(" ");
                next = balloon.value;
            } else { // 음수
                next = Math.abs(next);
                for (int i = 0; i < next - 1; i++) {
                    dq.addFirst(dq.pollLast());
                }
                Balloon balloon = dq.pollLast();
                sb.append(balloon.number).append(" ");
                next = balloon.value;
            }
        }
        System.out.println(sb);
    }
}
