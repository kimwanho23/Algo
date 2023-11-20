import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int FF = Integer.parseInt(st.nextToken());
        int FS = Integer.parseInt(st.nextToken());
        int SF = Integer.parseInt(st.nextToken());
        int SS = Integer.parseInt(st.nextToken());

        int answer = 0;

        if (FF != 0 || FS !=0) { //빠른 노래가 존재한다면
            if (FF == 0){ //FF가 없을 때,
                if (FS > SF){ //FS가 많을 때
                    answer = (SF * 2) + (SS + 1);
                }
                else if (FS < SF){ //SF가 많을 때
                    if (SS == 0){
                        answer = 2 * FS;
                    }
                    else{
                        answer = (2 * FS) + SS;
                    }
                }
                else{
                    answer = (FS * 2) + SS;
                }
            }
            else if (FS == 0){ //FS가 없을 때
                answer = FF;
            }
            else{ //FF FS 둘 다 존재할 때
                if (FS > SF){
                    if (SF == 0){ //SF만 0개
                        answer = FF + SS + 1;
                    }
                    else{ // 전부 존재
                        answer = FF + SS + (2 * SF + 1);
                    }
                }
                else{ //SF가 더 크거나 같다면?
                    answer = FF + SS + (2 * FS);
                }
            }

        }

        else { //느린 노래만 존재한다면
            if (SF == 0){
                answer = SS;
            }
            else if (SS == 0){
                answer = 1;
            }
            else
                answer = SS + 1;
        }

        System.out.println(answer);
    }
}
