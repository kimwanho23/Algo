import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution
{
 static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine()); // 테스트 케이스 번호

            StringTokenizer st = new StringTokenizer(br.readLine());

            q = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                q.add(Integer.parseInt(st.nextToken())); // 8개의 데이터 등록
            }
            
            int count = 1;

            while (true){
                if (count > 5) count = 1;
                int number = q.remove(); // 큐의 첫 번째 숫자

                if (number - count <= 0){
                    number = 0;
                    q.add(number);
                    break;
                } else {
                    number -= count;
                    q.add(number);
                }
                count++;
            }
            sb.append("#").append(N).append(" ");
            while (!q.isEmpty()){
                sb.append(q.remove()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}