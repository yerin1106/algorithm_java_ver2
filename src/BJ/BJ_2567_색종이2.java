package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2567_색종이2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] map = new int[101][101];

        int n = Integer.parseInt(br.readLine());
        for(int t=0; t<n; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int i=b; i<b+10; i++){
                for(int j=a; j<a+10; j++){
                    map[i][j] = 1;
                }
            }
        }

        int cnt = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                if(map[i][j] == 1){
                    for(int k=0; k<4; k++){
                        int rx = i + dx[k];
                        int ry = j + dy[k];

                        if(map[rx][ry] == 0 || rx < 0 || rx > 100 || ry < 0 || ry > 100) {
                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
