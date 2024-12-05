import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 국가의 수
        int K = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가

        List<Nation> nationList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            Nation nation = new Nation(number, gold, silver, bronze);
            nationList.add(nation);
        }

        Collections.sort(nationList);
        nationList.get(0).rank = 1; // 첫 번째 나라는 1등

        for (int i = 1; i < N; i++) {
            Nation now = nationList.get(i);
            Nation before = nationList.get(i - 1);

            if (now.gold == before.gold &&
                    now.silver == before.silver &&
                    now.bronze == before.bronze) {
                now.rank = before.rank;
            } else {
                now.rank = i + 1; // 메달이 다르면 현재 순서에 따라 랭크 부여
            }
        }
        for (Nation n : nationList) {
            if (n.number == K) {
                System.out.println(n.rank);
                break;
            }
        }
    }

    static class Nation implements Comparable<Nation> {
        private int number;
        private int gold;
        private int silver;
        private int bronze;
        private int rank;

        public Nation(int number, int gold, int silver, int bronze) {
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rank = 1;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                } else {
                    return o.silver - this.silver;
                }
            } else {
                return o.gold - this.gold;
            }
        }
    }
}
