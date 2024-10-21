import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int count;
    static int N, M;
    static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = 0;
        set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            if (set.contains(tmp)){
                result.add(tmp);
            }
        }
        Collections.sort(result);

        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
