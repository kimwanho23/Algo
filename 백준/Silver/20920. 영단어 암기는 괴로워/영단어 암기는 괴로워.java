import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 영어 지문에 나오는 단어의 개수
        int M = Integer.parseInt(st.nextToken()); // 단어 길이의 기준(최소 길이)

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() < M) continue; // 길이가 'm' 미만인 단어는 무시
            map.put(s, map.getOrDefault(s, 0) + 1); // 이미 나온 단어인 경우 카운트 증가, 처음 나온 단어인 경우 1로 설정
        }

        List<String> words = getStrings(map);

        for (String str : words) {
                sb.append(str).append("\n");
            }
        System.out.println(sb);
    }

    private static List<String> getStrings(Map<String, Integer> map) {
        List<String> words = new ArrayList<>(map.keySet());

        words.sort((o1, o2) -> {
            // 자주 등장하는 단어 순서대로 정렬
            if ((int) map.get(o1) != map.get(o2)) {
                return Integer.compare(map.get(o2), map.get(o1));
            }
            // 등장 횟수가 같으면 길이가 긴 단어가 먼저 오도록 정렬
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            // 등장 횟수와 길이가 같으면 사전 순으로 정렬
            return o1.compareTo(o2);
        });
        return words;
    }
}
