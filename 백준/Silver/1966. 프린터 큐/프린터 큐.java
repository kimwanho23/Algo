import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            Deque<target> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // Queue 순서


            int count = 0;
            Integer[] a = new Integer[N]; //중요도 배열
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int imp = Integer.parseInt(st.nextToken()); // 중요도
                if (j != M){
                    q.add(new target(imp, false));
                }
                else {
                    q.add(new target(imp, true));
                }

                a[j] = imp;
            }
            Arrays.sort(a, Collections.reverseOrder()); //중요도 배열 정렬

            while (true){
                target r = q.removeFirst();
                if (!Objects.equals(r.important, a[count])){ //중요도 배열과 요소가 다르면 맨 뒤로
                    q.addLast(r);
                }
                else {
                    count++;
                    if (r.target){
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}

class target{
    Integer important; // 중요도
    Boolean target;

    public target(Integer important, Boolean target) {
        this.important = important;
        this.target = target;
    }
}