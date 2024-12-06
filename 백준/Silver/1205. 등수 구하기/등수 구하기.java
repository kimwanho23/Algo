import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static Integer[] scoreArr, rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 리스트에 있는 점수 목록(리스트 크기)
        int score = Integer.parseInt(st.nextToken()); // 태수의 새로운 점수
        int P = Integer.parseInt(st.nextToken()); // 랭킹 리스트에 올라갈 수 있는 점수의 개수

        if (N == 0) { // 점수가 아무것도 없다면
            System.out.println(1);
            return;
        }


        scoreArr = new Integer[N];
        rank = new Integer[N];

        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scoreArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(scoreArr, Collections.reverseOrder());

        rank[0] = 1;
        for (int i = 1; i < N; i++) {
            if (Objects.equals(scoreArr[i], scoreArr[i - 1])){ // 순위 계산
                rank[i] = rank[i - 1];
            } else {
                rank[i] = i + 1;
            }
        }

        if ((score <= scoreArr[N - 1] && N == P)){ // 랭킹이 꽉 찼을 때
            System.out.println(-1);
            return; // 랭킹 밖
        } else {
            for (int i = 0; i < N; i++) {
                if (score > scoreArr[i]) {
                    System.out.println(rank[i]);
                    return;
                } else if (score == scoreArr[i]) {
                    while (i < N) {
                        if (score == scoreArr[i]) {
                            i++;
                        } else break;
                    }
                    System.out.println(rank[i - 1]);
                    return;
                }
            }
        }
        System.out.println(N + 1);

    }
}
