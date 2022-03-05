package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10157_자리배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        if(n > r*c){
            System.out.println(0);
            System.exit(0);
        }

        int[][] map = new int[r][c];
        int ans = 1;

        //상우하좌
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = r-1;
        int y = 0;
        int dir = 0;
        while(ans != n){

            map[x][y] = ans;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx<0 || nx>=r || ny<0 || ny>=c || map[nx][ny] != 0){
                dir = (dir+1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            x = nx;
            y = ny;

            ans++;
        }
        System.out.println((y+1) + " " + (r-x));
    }
}
