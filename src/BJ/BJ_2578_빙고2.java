package BJ;

import java.util.Scanner;

public class BJ_2578_빙고2 {
    static int[][] map;
    static int std;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        map = new int[5][5];

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for(int t=0; t<25; t++){
            int num = sc.nextInt();
            cnt++;
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(map[i][j] == num){
                        map[i][j] = 0;
                        search();
                    }

                    if(std >= 3) {
                        System.out.println(cnt);
                        System.exit(0);
                    }
                }
            }
        }

    }
    public static void search(){
        std = 0;
        int cnt = 0;
        for(int i=0; i<5; i++){
            cnt = 0;
            for(int j=0; j<5; j++){
                if(map[i][j] == 0) cnt ++;
                else break;
            }
            if(cnt == 5) std++;
        }

        // 세로줄 탐색
        for(int i=0; i<5; i++){
            cnt = 0;
            for(int j=0; j<5; j++){
                if(map[j][i] == 0) cnt ++;
                else break;
            }
            if(cnt == 5) std++;
        }

        // 대각선 탐색(좌상우하)
        cnt = 0;
        for(int i=0; i<5; i++){
            if(map[i][i] == 0) cnt++;
        }
        if(cnt == 5) std++;

        // 대각선 탐색(좌하우상)
        cnt = 0;
        for(int i=0; i<5; i++){
            if(map[i][4-i] == 0) cnt++;
        }
        if(cnt == 5) std++;
    }
}
