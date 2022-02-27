import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10157_자리배정_2027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        int[][] map = new int[r][c];

        int rx = r-1;
        int ry = 0;

        int idx = 0;
        int cnt = 1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(true){
            if(r*c < k) {
                System.out.println(0);
                break;
            }

            if(cnt == k) {
                System.out.println((ry+1) + " " + Math.abs(rx-r));
                break;
            }

            if(map[rx][ry] == 0){
                map[rx][ry] = cnt;
                cnt++;
            }

            rx = rx + dx[idx];
            ry = ry + dy[idx];

            if(rx < 0 || rx >= r || ry < 0 || ry >= c || map[rx][ry] != 0) {
                // 원상복귀
                rx = rx - dx[idx];
                ry = ry - dy[idx];

                idx = (idx+1) % 4;

                // 재배치
                rx = rx + dx[idx];
                ry = ry + dy[idx];
            }


//            for(int i=0; i<r; i++){
//                for(int j=0; j<c; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("---------------------");
        }
    }
}
