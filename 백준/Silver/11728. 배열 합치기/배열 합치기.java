import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr1, arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =  new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        arr1 = new int[A];
        arr2 = new int[B];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int index1 = 0, index2 = 0;

        while (index1 != A && index2 != B) {
            if (arr1[index1] > arr2[index2]) {
                sb.append(arr2[index2++]).append(" ");
            } else {
                sb.append(arr1[index1++]).append(" ");
            }

            if (index1 == A) {
                for (int i = index2; i < B; i++) {
                    sb.append(arr2[i]).append(" ");
                }
                break;
            }
            else if (index2 == B) {
                for (int i = index1; i < A; i++) {
                    sb.append(arr1[i]).append(" ");
                }
                break;
            }
        }
        System.out.println(sb);
    }
}
