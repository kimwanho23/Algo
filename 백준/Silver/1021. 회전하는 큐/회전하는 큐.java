import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;
        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑아내려고 하는 수의 개수

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            list.offer(i);
        }

        int[] seq = new int[M];

        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(st.nextToken());

            int target_idx = list.indexOf(a); // 입력받은 숫자 인덱스
            int half_idx;

            if (list.size() % 2 == 0){
                half_idx = list.size() / 2 - 1;
            }
            else {
                half_idx = list.size() / 2;
            }

            if (target_idx <= half_idx) {
                for (int j = 0; j < target_idx; j++) {
                    int temp = list.pollFirst();
                    list.offerLast(temp);
                    total++;
                }
            } else {
                for (int j = 0; j < list.size() - target_idx; j++) {
                    int temp = list.pollLast();
                    list.offerFirst(temp);
                    total++;
                }
            }
            list.pollFirst();
        }
        System.out.println(total);

    }
}
