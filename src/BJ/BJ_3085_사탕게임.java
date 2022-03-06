package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3085_사탕게임 {
    static int n;
    static String[][] map;
    static int max;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new String[n][n];

        for(int i=0; i<n; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<n; j++){
                map[i][j] = line[j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                check(i,j);
            }
        }
        System.out.println(max);
    }

    public static void check(int x, int y){
        int rx = x, ry = y;
        for(int i=0; i<4; i++){
            rx = x + dx[i];
            ry = y + dy[i];

            if(rx < 0 || rx >= n || ry < 0 || ry >= n) continue;

            if(map[x][y].equals(map[rx][ry])) continue;
            else{
                String tmp = map[x][y];
                map[x][y] = map[rx][ry];
                map[rx][ry] = tmp;

                max = Math.max(max, count());

                //원상복귀
                tmp = map[x][y];
                map[x][y] = map[rx][ry];
                map[rx][ry] = tmp;
            }
        }
    }

    public static int count(){
        int ans = 0;

        for(int i=0; i<n; i++){
            //행검사
            int cnt = 1;
            for(int j=1; j<n; j++){
                if(map[i][j].equals(map[i][j-1])){
                    cnt++;
                }
                else{
                    cnt = 1;
                }
                ans = Math.max(ans, cnt);
            }

            //열검사
            cnt = 1;
            for(int j=1; j<n; j++){
                if(map[j][i].equals(map[j-1][i])){
                    cnt++;
                }
                else{
                    cnt = 1;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
