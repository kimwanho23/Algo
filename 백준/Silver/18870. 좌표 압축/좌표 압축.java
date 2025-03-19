import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr, sorted;
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // N개의 좌표

        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new HashMap<>();

        arr = new int[N];
        sorted = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int rank = 0;
        for (int i : sorted) {
            if (!map.containsKey(i)) {
                map.put(i, rank);
                rank++;
            }
        }

        for (int i : arr) {
            int ranking = map.get(i);
            sb.append(ranking).append(" ");
        }
        System.out.println(sb);
    }
}
