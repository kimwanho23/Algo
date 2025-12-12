import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Coor{
        int x;
        int y;

        public Coor(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 점의 개수

        List<Coor> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x좌표
            int y = Integer.parseInt(st.nextToken()); // y좌표
            list.add(new Coor(x,y));
        }

        list.sort((o1, o2) -> {
            if (o1.x == o2.x){
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });
        
        for (Coor c : list){
            sb.append(c.x).append(" ").append(c.y).append("\n");
        }
        System.out.println(sb);
    }
}
