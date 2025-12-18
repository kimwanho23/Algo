import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        arr = new String[N][N];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = "*";
            }
        }
        recursive(0, 0, N);
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void recursive(int startX, int startY, int size){
        if (size == 1){
            return;
        }
        int newSize = size / 3;

        for (int i = startX + newSize; i < startX + 2 * newSize; i++) {
            for (int j = startY + newSize; j < startY + 2 * newSize; j++) {
                arr[i][j] = " ";
            }
        }
        // (0, 0) (3, 0) (6, 0)
        // (0, 3) (3, 3) (6, 3)
        // (0, 6) (3, 6) (6, 6)

        recursive(startX, startY, newSize);
        recursive(startX + newSize, startY, newSize);
        recursive(startX + 2 * newSize, startY, newSize);

        recursive(startX, startY + newSize, newSize);
        recursive(startX + 2 * newSize, startY + newSize, newSize);

        recursive(startX, startY + 2 * newSize, newSize);
        recursive(startX + newSize, startY + 2 * newSize, newSize);
        recursive(startX + 2 * newSize, startY + 2 * newSize, newSize);



    }
}
