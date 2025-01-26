import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 도감에 수록된 포켓몬 N
        // 내가 맞춰야 하는 문제 개수 M
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> pokemon = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            pokemon.put(String.valueOf(i), name);
            pokemon.put(name, String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            String result = pokemon.get(s);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
