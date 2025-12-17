import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 수의 개수(홀수)

        int[] arr = new int[N];
        double sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            int r = Integer.parseInt(br.readLine());
            sum += r;
            arr[i] = r;
            map.put(r, map.getOrDefault(r, 0) + 1);
            max = Math.max(max, map.get(r));
        }

        List<Integer> list2 = new ArrayList<>();

        for (Integer integer : map.keySet()) { // 최빈값 리스트
            if (map.get(integer) == max) {
                list2.add(integer);
            }
        }
        Collections.sort(list2);

        Arrays.sort(arr);

        sb.append(Math.round(sum / N)).append("\n"); // 산술 평균
        sb.append(arr[arr.length / 2]).append("\n"); // 중앙값
        if (list2.size() > 1) {
            sb.append(list2.get(1)).append("\n"); // 최빈값
        } else {
            sb.append(list2.get(0)).append("\n");
        }

        sb.append(arr[arr.length - 1] - arr[0]).append("\n"); // 범위

        System.out.println(sb);
    }
}
