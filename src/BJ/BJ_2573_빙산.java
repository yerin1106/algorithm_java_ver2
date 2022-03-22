package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2573_빙산 {

    static int n, m;

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int ice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        boolean flag = false;
        while(true){
            flag = false;
            ice = 0;
            visited = new boolean[n][m];
            //전부 다 녹을 때까지 두 덩어리 이상으로 분리되지 않으면 프로그램은 0을 출력
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] != 0) flag = true;
                }
            }

            if(!flag){
                System.out.println(0);
                break;
            }

            // 덩어리 check, 덩어리가 2개 이상이면 break;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] != 0 && visited[i][j] == false) {
                        bfs(i,j);
                        ice++;
                    }
                }
            }

            //System.out.println(year + " " + ice);

            if(ice >= 2) {
                System.out.println(year);
                break;
            }

            // 녹는거 4방탐색
            year++;
            int[][] tmp = new int[n][m];
            for(int i=0; i<tmp.length; i++){
                System.arraycopy(map[i], 0, tmp[i], 0, map[0].length);
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] != 0) {
                        for(int k=0; k<4; k++){
                            int rx = i+dx[k];
                            int ry = j+dy[k];

                            if(rx < 0 || rx >= n || ry < 0 || ry >= m) continue;

                            if(map[rx][ry] == 0 && tmp[i][j] > 0) tmp[i][j]--;
                        }
                    }
                }
            }
            for(int i=0; i<map.length; i++){
                System.arraycopy(tmp[i], 0, map[i], 0, tmp[0].length);
            }
        }
    }

    public static void bfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int rx = x+dx[i];
            int ry = y+dy[i];

            if(rx < 0 || rx >= n || ry < 0 || ry >= m) continue;

            if(visited[rx][ry]) continue;

            if(map[rx][ry] != 0) bfs(rx, ry);
        }
    }
}
