package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_키순서 {

    public static int n;
    public static int[][] map;
    public static int tCnt, sCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());
        for(int t=1; t<=tc; t++){
            n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            map = new int[n+1][n+1];
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[a][b] = 1;
            }

            int res = 0;
            for(int i=1; i<n+1; i++){
                tCnt = 0;
                sCnt = 0;
                taller(i, new boolean[n+1]);
                smaller(i, new boolean[n+1]);

                if(tCnt+sCnt == n-1) res++;
            }

            System.out.println("#" + t + " " + res);
        }
    }

    public static void taller(int from, boolean[] visited){
        visited[from] = true;

        for(int i=1; i<n+1; i++){
            if(!visited[i] && map[from][i] == 1){
                taller(i, visited);
                tCnt++;
            }
        }
    }

    public static void smaller(int to, boolean[] visited){
        visited[to] = true;

        for(int i=1; i<n+1; i++){
            if(!visited[i] && map[i][to] == 1) {
                smaller(i, visited);
                sCnt++;
            }
        }
    }
}
