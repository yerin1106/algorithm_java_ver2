package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_특이한자석 {

    static int[][] magnet;
    static int[][] copyMagnet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=t; tc++){
            int k = Integer.parseInt(br.readLine());

            magnet = new int[4][8];
            copyMagnet = new int[4][8];
            for(int i=0; i<4; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<8; j++){
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int number = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());

                if(direction == 1) move(number);
                else rmove(number);
            }

            int res = magnet[0][0] * 1 + magnet[1][0] * 2 + magnet[2][0] * 4 + magnet[3][0] * 8;
            System.out.println("#" + tc + " " + res);
        }
    }

    //시계방향 이동
    public static void move(int number){
        copy(copyMagnet, magnet);
        // 본인 이동
        turn(number-1);

        switch (number){
            case 1:
                if(magnet[0][2] != magnet[1][6]){
                    turnRe(1);
                    if(magnet[1][2] != magnet[2][6]){
                        turn(2);
                        if(magnet[2][2] != magnet[3][6]) turnRe(3);
                    }
                }
                break;
            case 2:
                // 1,2 비교
                if(magnet[0][2] != magnet[1][6]){
                    turnRe(0);
                }
                // 2,3 비교
                if(magnet[1][2] != magnet[2][6]){
                    turnRe(2);
                    if(magnet[2][2] != magnet[3][6]) turn(3);
                }
                break;
            case 3:
                // 2,3 비교
                if(magnet[1][2] != magnet[2][6]){
                    turnRe(1);
                    if(magnet[0][2] != magnet[1][6]) turn(0);
                }
                // 3,4 비교
                if(magnet[2][2] != magnet[3][6]){
                    turnRe(3);
                }
                break;
            case 4:
                // 3,4 비교
                if(magnet[2][2] != magnet[3][6]){
                    turnRe(2);
                    if(magnet[1][2] != magnet[2][6]){
                        turn(1);
                        if(magnet[0][2] != magnet[1][6]) turnRe(0);
                    }
                }
                break;
        }
        copy(magnet, copyMagnet);
    }

    // 반시계방향 이동
    public static void rmove(int number){
        copy(copyMagnet, magnet);
        // 본인 이동
        turnRe(number-1);

        switch (number){
            case 1:
                if(magnet[0][2] != magnet[1][6]){
                    turn(1);
                    if(magnet[1][2] != magnet[2][6]){
                        turnRe(2);
                        if(magnet[2][2] != magnet[3][6]) turn(3);
                    }
                }
                break;
            case 2:
                // 1,2 비교
                if(magnet[0][2] != magnet[1][6]){
                    turn(0);
                }
                // 2,3 비교
                if(magnet[1][2] != magnet[2][6]){
                    turn(2);
                    if(magnet[2][2] != magnet[3][6]) turnRe(3);
                }
                break;
            case 3:
                // 2,3 비교
                if(magnet[1][2] != magnet[2][6]){
                    turn(1);
                    if(magnet[0][2] != magnet[1][6]) turnRe(0);
                }
                // 3,4 비교
                if(magnet[2][2] != magnet[3][6]){
                    turn(3);
                }
                break;
            case 4:
                // 3,4 비교
                if(magnet[2][2] != magnet[3][6]){
                    turn(2);
                    if(magnet[1][2] != magnet[2][6]){
                        turnRe(1);
                        if(magnet[0][2] != magnet[1][6]) turn(0);
                    }
                }
                break;
        }
        copy(magnet, copyMagnet);
    }

    public static void turn(int n){
        copyMagnet[n][0] = magnet[n][7];
        for(int i=0; i<7; i++){
            copyMagnet[n][i+1] = magnet[n][i];
        }
    }

    public static void turnRe(int n){
        copyMagnet[n][7] = magnet[n][0];
        for(int i=0; i<7; i++){
            copyMagnet[n][i] = magnet[n][i+1];
        }
    }

    public static void copy(int[][] a, int[][] b){
        for(int i=0; i<4; i++){
            for(int j=0; j<8; j++){
                a[i][j] = b[i][j];
            }
        }
    }
}
