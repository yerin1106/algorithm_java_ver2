import java.util.Scanner;

public class BJ_2578_빙고 {
    static int[][] bingo;
    static int std;
    static int x;
    static int y;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int[][] map1 = new int[5][5];
        int[][] map2 = new int[5][5];

        bingo = new int[5][5];

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                map1[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                map2[i][j] = sc.nextInt();
            }
        }

        int result = 0;
        for(int i=0; i<5; i++){
            if(std >= 3) break;
            for(int j=0; j<5; j++){
                contain(map1, map2[i][j]);
                bingo[x][y] = 1;
                search();
                result ++;
                if(std >= 3) {
                    System.out.println(result);
                    break;
                }
            }
        }
    }

    public static void contain(int[][] map1, int num){
        x = -1;
        y = -1;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(map1[i][j] == num){
                    x = i;
                    y = j;
                    break;
                }
            }
            if(x != -1 && y != -1) break;
        }
    }

    public static void search(){
        // 가로줄 탐색
        std = 0;
        int cnt = 0;
        for(int i=0; i<5; i++){
            cnt = 0;
            for(int j=0; j<5; j++){
                if(bingo[i][j] == 1) cnt ++;
                else break;
            }
            if(cnt == 5) std++;
        }

        // 세로줄 탐색
        for(int i=0; i<5; i++){
            cnt = 0;
            for(int j=0; j<5; j++){
                if(bingo[j][i] == 1) cnt ++;
                else break;
            }
            if(cnt == 5) std++;
        }

        // 대각선 탐색(좌상우하)
        cnt = 0;
        for(int i=0; i<5; i++){
           if(bingo[i][i] == 1) cnt++;
        }
        if(cnt == 5) std++;

        // 대각선 탐색(좌하우상)
        cnt = 0;
        for(int i=0; i<5; i++){
            if(bingo[i][4-i] == 1) cnt++;
        }
        if(cnt == 5) std++;
    }
}
