package BJ;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int h, w;
    static int map[][];

    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0; //전체 걸리는 시간
        int cnt = 0; //녹기 한 시간 전 칸의 개수

        while(!start()){
            cnt = count();
            visited = new boolean[h][w];

            dfs(0,0);
            melt();

            time++;
        }
        System.out.println(time);
        System.out.println(cnt);

//        while (true) {
//            if (start()) {
//                System.out.println(cnt);
//                break;
//            }
//
//            cnt++;
//            int[][] tmp = new int[h][w];
//            for (int i = 0; i < tmp.length; i++) {
//                System.arraycopy(map[i], 0, tmp[i], 0, map[0].length);
//            }
//
//            visited = new boolean[h][w];
//            int count = count();
//            int check = 0;
//            for (int i = 0; i < h; i++) {
//                for (int j = 0; j < w; j++) {
//                    if (map[i][j] == 1) {
//                        visited = new boolean[h][w];
//                        if (check(i, j)) {
//                            tmp[i][j] = 0;
//                            check++;
//                        }
//                    }
//                }
//            }
//            System.out.println("-----------" + cnt + "---------------------");
//            for (int i = 0; i < h; i++) {
//                for (int j = 0; j < w; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//
//            if(count == check) {
//                System.out.println(count);
//            }
//
//            for (int i = 0; i < map.length; i++) {
//                System.arraycopy(tmp[i], 0, map[i], 0, tmp[0].length);
//            }
//        }
    }

    // 녹일 수 있는 부분인지 확인 (바깥 공기 check)
    public static void dfs(int x, int y){
        if(visited[x][y] || map[x][y] != 0)
            return;

        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int rx = x + dx[i];
            int ry = y + dy[i];

            if (rx < 0 || rx >= h || ry < 0 || ry >= w) continue;
            if(!visited[rx][ry] || map[rx][ry] == 0) dfs(rx, ry);
        }
    }

    //치즈 녹이기
    public static void melt(){
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] == 1){
                    if(isMelt(i, j)){
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    //녹일 수 있는지 여부 확인
    public static boolean isMelt(int x, int y){
        for(int i=0; i<4; i++){
            int rx = x + dx[i];
            int ry = y + dy[i];

            if(visited[rx][ry]) return true;
        }
        return false;
    }

    // 다 녹았는지 확인
    public static boolean start() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] != 0) return false;
            }
        }
        return true;
    }

    // 치즈칸 수 세기
    public static int count(){
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] != 0) cnt++;
            }
        }
        return cnt;
    }

//    public static boolean check(int x, int y) {
//        visited[x][y] = true;
//        for (int i = 0; i < 4; i++) {
//            int rx = x + dx[i];
//            int ry = y + dy[i];
//
//            if (rx < 0 || rx >= h || ry < 0 || ry >= w) return true;
//            if (map[rx][ry] == 1) break;
//            if(!visited[rx][ry]) {
//                check(rx, ry);
//            }
//        }
//        return false;
//    }
}
