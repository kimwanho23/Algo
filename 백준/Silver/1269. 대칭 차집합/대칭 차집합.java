import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // A 개수
        int B = Integer.parseInt(st.nextToken()); // B 개수
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            setA.add(Integer.valueOf(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            setB.add(Integer.valueOf(st.nextToken()));
        }

        for (Integer i : setA) {
            if (!setB.contains(i)){
                count++;
            }
        }

        for (Integer i : setB) {
            if (!setA.contains(i)){
                count++;
            }
        }
        System.out.println(count);
    }
}
