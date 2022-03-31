package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1986_체스 {

    static int[][] map;
    static int n, m;
    static int q, k;

    static int[] qx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] qy = {-1, 0, 1, 1, 1, 0, -1, -1};

    static int[] kx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] ky = {-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        //Queen = 1
        st = new StringTokenizer(br.readLine());
        q = Integer.parseInt(st.nextToken());
        for(int i=0; i<q; i++){
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = 1;
        }

        //Knight = 2
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        for(int i=0; i<k; i++){
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = 2;
        }

        //Pwan = 3
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        for(int i=0; i<p; i++){
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = 3;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1) Queen(i, j);
                else if(map[i][j] == 2) Knight(i, j);
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0) cnt++;
            }
        }

        System.out.println(cnt);
    }

    // Queen 이동 가능한 칸이면 -1
    public static void Queen(int x, int y){
        for(int i=0; i<qx.length; i++){
            int rx = x;
            int ry = y;

            while (true){
                rx = rx + qx[i];
                ry = ry + qy[i];

                if(rx < 0 || rx >= n || ry < 0 || ry >= m) break; //범위 벗어남
                if(map[rx][ry] == 1 || map[rx][ry] == 2 || map[rx][ry] == 3) break; //장애물 만남

                map[rx][ry] = -1;
            }
        }
    }

    // Knight 이동 가능한 칸이면 -1
    public static void Knight(int x, int y){
        for(int i=0; i<kx.length; i++){
            int rx = x + kx[i];
            int ry = y + ky[i];

            if(rx < 0 || rx >= n || ry < 0 || ry >= m || map[rx][ry] != 0) continue;

            map[rx][ry] = -2;
        }
    }
}
