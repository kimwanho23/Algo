class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] work = new int[players.length + k];
        int worker = 0;
        
        for (int i = 0; i < players.length; i++) {
            worker -= work[i]; // 서버 빼기
            int required = players[i] / m; // 서버 요구량
            
            if (required > worker) { // 요구량이 현재 서버보다 많다면?
                int server = required - worker; // 추가할 서버
                worker += server;
                answer += server;
                work[i + k] += server;
            }
        }
        
        return answer;
    }
    
}