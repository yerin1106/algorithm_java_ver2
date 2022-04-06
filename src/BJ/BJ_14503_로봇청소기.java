package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503_로봇청소기 {

    // 0=북, 1=동, 2=남, 3=서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n, m, map[][];

    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//입력

        //clean(r, c, d, 0);

        clean(r, c, d);

        System.out.println(res);
    }

    private static void clean(int row, int col, int direction){
        //1.현재 위치를 청소한다.
        if(map[row][col] == 0){
            map[row][col] = 2;
            res++;
        }

        //2.현재 위치에서 다음을 반복하면서 인접한 칸을 탐색한다
        boolean flag = false;
        int origin = direction;
        for(int i=0; i<4; i++){
            int next_d = (direction + 3) % 4;
            int next_r = row + dx[next_d];
            int next_c = col + dy[next_d];

            if(next_r > 0 && next_c > 0 && next_r < n && next_c < m){
                if(map[next_r][next_c] == 0){
                    clean(next_r, next_c, next_d);
                    flag = true;
                    break;
                }
            }
            direction = (direction + 3) % 4;
        }

        //네방향 모두 청소가 되어있거나 벽인 경우
        if(!flag){
            int next_d = (origin + 2) %4;
            int next_br = row + dx[next_d];
            int next_bc = col + dy[next_d];

            if(next_br > 0 && next_bc > 0 && next_br < n && next_bc < m){
                if(map[next_br][next_bc] != 1){
                    clean(next_br, next_bc, origin);
                }
            }
        }
    }

//    private static void clean(int r, int c, int d, int cnt){
//        map[r][c] = -1; //1.현재 위치를 청소한다.
//        if(cnt == 4){
//            int mx = 0, my = 0;
//            switch (d){
//                case 0:
//                    mx = r+1;
//                    my = c;
//                    break;
//                case 1:
//                    mx = r;
//                    my = c+1;
//                    break;
//                case 2:
//                    mx = r-1;
//                    my = c;
//                    break;
//                case 3:
//                    mx = r;
//                    my = c-1;
//                    break;
//            }
//            if(mx < 0 || my < 0 || mx >= n || my >= m || map[mx][my] == 1) return;
//            clean(mx, my, d, 0);
//        }
//
//        // 현재 위치에서 다음을 반복하면서 인접한 칸을 탐색한다.
//        int rx = r + dx[((d+1)%4)];
//        int ry = c + dy[((d+1)%4)];
//
//        if(rx < 0 || ry < 0 || rx >= n || ry >= m) clean(r, c, (d+1)%4, cnt+1);
//
//        if(map[rx][ry] == 0) {//아직 청소하지 않은 빈 공간이 현재 위치에 바로 왼쪽에 위치
//            clean(rx, ry, ((d+1)%4), 0);
//        } else{
//            clean(r, c, ((d+1)%4), cnt+1);
//        }
//    }
}
