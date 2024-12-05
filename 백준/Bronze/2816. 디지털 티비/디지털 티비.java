import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 채널의 수 N

        arr = new String[N];
        int kbs1Index = 0;
        int kbs2Index = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            if (arr[i].equals("KBS1")){
                kbs1Index = i;
            } else if (arr[i].equals("KBS2")) {
                kbs2Index = i;
            }
        }
        int currentIndex = 0;
            while(currentIndex != kbs1Index){
                currentIndex++;
                sb.append("1");
            }
            while(currentIndex != 0){
                currentIndex--;
                sb.append("4");
                if (currentIndex == kbs2Index) {
                    kbs2Index++;
                }
            }
            while(currentIndex != kbs2Index){
                currentIndex++;
                sb.append("1");
            }
            while(currentIndex != 1){
                currentIndex--;
                sb.append("4");
            }


        System.out.println(sb);
    }
}

