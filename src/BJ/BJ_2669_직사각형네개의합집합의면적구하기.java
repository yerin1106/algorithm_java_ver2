package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2669_직사각형네개의합집합의면적구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[4][4];
        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] map = new int[100][100];
        for(int i=0; i<4; i++){
            for(int j=arr[i][0]; j<arr[i][2]; j++){
                for(int k=arr[i][1]; k<arr[i][3]; k++){
                    map[j][k] = 1;
                }
            }

        }

        int cnt = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j] == 1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
