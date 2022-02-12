import java.util.Arrays;
import java.util.Scanner;

public class BJ_2564_경비원{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //가로
        int m = sc.nextInt(); //세로

        int cnt = sc.nextInt(); //상점의 수

        //1: 북쪽, 2: 남쪽, 3: 서쪽, 4: 동쪽
        // 북쪽, 남쪽 => 왼쪽으로부터의 거리
        // 서쪽, 동쪽 => 위쪽으로부터의 거리
        int[][] street = new int[cnt][2];
        for(int i=0; i<cnt; i++){
            for(int j=0; j<2; j++){
                street[i][j] = sc.nextInt();
            }
        }

        int[][] location = new int[1][2];
        for(int i=0; i<1; i++){
            for(int j=0; j<2; j++){
                location[i][j] = sc.nextInt();
            }
        }

        int result = 0;
        for(int i=0; i<cnt; i++){
            if(location[0][0] == 1){
                switch (street[i][0]){
                    case 1:
                        result += Math.abs(location[0][1] - street[i][1]);
                        break;
                    case 2:
                        int a = location[0][1] + m + street[i][1];
                        int b = (n - location[0][1]) + m + (n-street[i][1]);
                        result += Math.min(a,b);
                        break;
                    case 3:
                        result += location[0][1] + street[i][1];
                        break;
                    case 4:
                        result += (n-location[0][1] + street[i][1]);
                        break;
                }
            }
            else if(location[0][0] == 2){
                switch (street[i][0]){
                    case 1:
                        int a = location[0][1] + m + street[i][1];
                        int b = (n - location[0][1]) + m + (n-street[i][1]);
                        result += Math.min(a,b);
                        break;
                    case 2:
                        result += Math.abs(location[0][1] - street[i][1]);
                        break;
                    case 3:
                        result += location[0][1] + (m-street[i][1]);
                        break;
                    case 4:
                        result += (n-location[0][1] + (m-street[i][1]));
                        break;
                }
            }
            else if(location[0][0] == 3){
                switch (street[i][0]){
                    case 1:
                        result += location[0][1] + street[i][1];
                        break;
                    case 2:
                        result += (m-location[0][1]) + street[i][1];
                        break;
                    case 3:
                        result += Math.abs(location[0][1] - street[i][1]);
                        break;
                    case 4:
                        int a = location[0][1] + n + street[i][1];
                        int b = (m - location[0][1]) + n + (m-street[i][1]);
                        result += Math.min(a,b);
                        break;
                }
            }
            else if(location[0][0] == 4){
                switch (street[i][0]){
                    case 1:
                        result += location[0][1] + (n-street[i][1]);
                        break;
                    case 2:
                        result += (m-location[0][1]) + (n-street[i][1]);
                        break;
                    case 3:
                        int a = location[0][1] + n + street[i][1];
                        int b = (m - location[0][1]) + n + (m-street[i][1]);
                        result += Math.min(a,b);
                        break;
                    case 4:
                        result += Math.abs(location[0][1] - street[i][1]);
                        break;
                }
            }
        }

        System.out.println(result);
    }
}
