import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] A;
    static int[] P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        P = new int[N];

        // A 배열의 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // A 배열의 값과 그 인덱스를 저장하는 Pair 리스트 생성
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            pairs.add(new Pair(A[i], i));
        }

        // 값을 기준으로 정렬
        pairs.sort(Comparator.comparingInt(p -> p.value));

        // 정렬된 순서에 따라 P 배열의 값을 설정
        for (int i = 0; i < N; i++) {
            P[pairs.get(i).index] = i;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    // 값을 저장할 Pair 클래스 (값과 원래 인덱스)
    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}