import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= t; test_case++){
            int answer = 0;
            int k =  Integer.parseInt(br.readLine()); // 제곱
            st = new StringTokenizer(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            int N = (int) Math.pow(2, k);
            for (int i = 0; i < N; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }
            while (q.size()>1){
                int a1 = q.poll();
                int a2 = q.poll();
                answer += Math.abs(a1-a2);
                q.add(Math.max(a1, a2));
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}