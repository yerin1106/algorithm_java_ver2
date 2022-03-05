package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10163_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] map = new int[1001][1001];

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int j = x; j<x+w; j++){
                for(int k=y; k<y+h; k++){
                    map[j][k] = i+1;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            int cnt = 0;
            for(int j = 0; j<1001; j++){
                for(int k=0; k<1001; k++){
                    if(map[j][k] == i) cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
