package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13565_침투 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            String[] tmp = br.readLine().split("");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for(int i=0; i<n; i++){
            if(map[0][i] == 0) dfs(0, i);
        }

        if(check()) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void dfs(int x, int y){
        for(int i=0; i<4; i++){
            int rx = x+dx[i];
            int ry = y+dy[i];

            if(rx < 0 || rx >=m || ry <0 || ry >=n || map[rx][ry] != 0 || visited[rx][ry]) continue;

            if(map[rx][ry] == 0){
                visited[rx][ry] = true;
                map[rx][ry] = -1;
                dfs(rx, ry);
            }
        }
    }

    public static boolean check(){
        for(int i=0; i<n; i++){
            if(map[m-1][i] == -1) return true;
        }
        return false;
    }
}
