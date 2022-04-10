package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1949_등산로조성 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static int n, k;
    static ArrayList<int[]> point;

    static int res = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++){
            res = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            int max = 0;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(map[i][j], max);
                }
            } //입력

            //System.out.println("max " + max);

            point = new ArrayList<>();
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] == max){
                        point.add(new int[]{i, j});
                    }
                }
            } //list에 가장 높은 봉우리 저장

            //System.out.println(point);

            for(int a=0; a<=k; a++){
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        //if(map[i][j] - a < 0) continue;
                        //else map[i][j] -= a;
                        map[i][j] -= a;
                        for(int b=0; b<point.size(); b++){
                            dfs(point.get(b)[0], point.get(b)[1], 1, map);
                        }
                        map[i][j] = map[i][j] + a;
                    }
                }
            }
            System.out.println("#" + tc +" " +res);
        }
    }

    public static void dfs(int x, int y, int cnt, int[][] copy){
        for(int i=0; i<4; i++){
            int rx = x + dx[i];
            int ry = y + dy[i];

            if(rx < 0 || ry < 0 || rx >= n || ry >= n) continue;

            if(copy[x][y] > copy[rx][ry]) {
                dfs(rx, ry, cnt+1, copy);
            }
        }

        if(res < cnt) res = cnt;
    }
}