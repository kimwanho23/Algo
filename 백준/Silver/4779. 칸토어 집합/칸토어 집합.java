import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder cur;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);

            int len = (int) Math.pow(3, N);
            cur = new StringBuilder("-".repeat(len));

            recursive(0, len);
            System.out.println(cur);
        }
    }
    //
    public static void recursive(int start, int size){
        if (size == 1){
            return;
        }
        int newSize = size / 3;
        for (int i = start + newSize; i < start + 2 * newSize; i++) {
            cur.setCharAt(i, ' ');
        }

        recursive(start, newSize);
        recursive(start + 2 * newSize, newSize);
    }
}
