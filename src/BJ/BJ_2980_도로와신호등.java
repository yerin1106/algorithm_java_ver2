package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_2980_도로와신호등 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int l = Integer.parseInt(st.nextToken());
//
//        int[][] arr = new int[n][3];
//        for(int i=0; i<2; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j=0; j<3; j++){
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int loc = 0; //위치
//        int time = 0; //결과
//
//        for(int i=0; i<n; i++){
////            loc += arr[i][0] - arr[i-1][0];
////            tmp = (arr[i][1] + arr[i][2]) % time;
////
////            if(tmp >= arr[i][1]) time += arr[i][0] - arr[i-1][0];
////            else time += (arr[i][1] - tmp) + arr[i][0] - arr[i-1][0];
////
////            System.out.println(time);
//
//            time += (arr[i][0] - loc);
//            loc = arr[i][0];
//
//            int tmp = time % (arr[i][1] + arr[i][2]);
//            if(tmp  <= arr[i][1])
//                time += (arr[i][1] - time%(arr[i][1] + arr[i][2]));
//        }
//
//        time += l - arr[n-1][0];
//
//        System.out.println(time);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int t = 0;
        int pre = 0;

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            int r = sc.nextInt();
            int g = sc.nextInt();

            // t - 위치 d에 있는 신호등까지 걸린 시간
            t += d - pre;
            pre = d;

            int red = t % (r + g);
            if (red <= r) {
                // 빨간 불이 끝날때까지 대기
                t += r - red;
            }
        }
        System.out.println(t + (l - pre));

    }
}
