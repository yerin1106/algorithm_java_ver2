package SWEA;

import java.util.Scanner;

public class D2_1209_Sum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int t=0; t<10; t++){
            int n = sc.nextInt();
            int[][] arr = new int[100][100];

            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            int result;

            // 가로
            for(int i=0; i<100; i++){
                result = 0;
                for(int j=0; j<100; j++){
                    result += arr[i][j];
                }
                if(result > max) max = result;
            }

            //세로
            for(int i=0; i<100; i++){
                result = 0;
                for(int j=0; j<100; j++){
                    result += arr[j][i];
                }
                if(result > max) max = result;
            }

            //대각선(좌상우하)
            result = 0;
            for(int i=0; i<10; i++){
                result += arr[i][i];
            }
            if(result > max) max = result;

            //대각선(좌하우상)
            result = 0;
            for(int i=0; i<10; i++){
                result += arr[i][9-i];
            }
            if(result > max) max = result;

            System.out.printf("#%d %d\n", n, max);
        }
    }
}
