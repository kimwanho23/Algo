import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        if (game.equals("Y")) {
            System.out.println(set.size());
        } else if (game.equals("F")) {
            System.out.println(set.size() / 2);
        } else if (game.equals("O")) {
            System.out.println(set.size() / 3);
        }


    }
}
