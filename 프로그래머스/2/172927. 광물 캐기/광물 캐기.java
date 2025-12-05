import java.util.*;

class Solution {

    static class Group {
        int diamond; // 다이아 개수
        int iron;    // 철 개수
        int stone;   // 돌 개수
        int cost;    // 돌 곡괭이로 캤을 때의 피로도(정렬용)

        Group(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
            this.cost = diamond * 25 + iron * 5 + stone;
        }
    }

        public static int solution(int[] picks, String[] minerals) {
            int answer = 0;

            int totalPicks = picks[0] + picks[1] + picks[2];  // 곡괭이 총 개수
            int maxMinerals = Math.min(minerals.length, totalPicks * 5); // 캘 수 있는 최대 광물 수

            List<Group> groups = new ArrayList<>();

            for (int i = 0; i < maxMinerals; i += 5) {
                int diamond = 0;
                int iron = 0;
                int stone = 0;

                for (int j = i; j < i + 5 && j < maxMinerals; j++) {
                    String m = minerals[j];
                    if (m.equals("diamond")) diamond++;
                    else if (m.equals("iron")) iron++;
                    else stone++;
                }

                groups.add(new Group(diamond, iron, stone));
            }

            groups.sort(Comparator.comparingInt((Group g) -> g.cost).reversed());

            for (Group g : groups) {
                if (picks[0] > 0) {          // 다이아 곡괭이
                    picks[0]--;
                    // 어떤 광물이든 피로도 1
                    answer += g.diamond + g.iron + g.stone;
                } else if (picks[1] > 0) {   // 철 곡괭이
                    picks[1]--;
                    answer += g.diamond * 5 + g.iron + g.stone;
                } else if (picks[2] > 0) {   // 돌 곡괭이
                    picks[2]--;
                    answer += g.diamond * 25 + g.iron * 5 + g.stone;
                } else {
                    break; // 곡괭이 다 쓰면 종료
                }
            }

            return answer;
    }

}