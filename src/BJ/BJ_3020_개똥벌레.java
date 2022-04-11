package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3020_개똥벌레 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] top = new int[h+1];
        int[] bottom = new int[h+1];
        for(int i=0; i<n/2; i++){
            bottom[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }

        for(int i=1; i<h+1; i++){
            bottom[i] += bottom[i-1];
            top[i] += top[i-1];
        } //누적합

        int cnt=0, min=Integer.MAX_VALUE;
        for(int i=1; i<h+1; i++){
            int total = 0;

            total += bottom[h] - bottom[i-1];
            total += top[h] - top[h-i];

            if(min > total){
                cnt = 1;
                min = total;
            } else if(min == total) cnt++;
        }
        System.out.println(min + " " + cnt);
    }

//    public static void main2(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int h = Integer.parseInt(st.nextToken());
//
//        int[] arr = new int[h];
//        for(int i=0; i<n; i++){
//            int num = Integer.parseInt(br.readLine());
//            if(i%2 == 0){
//                for(int j=0; j<num; j++){
//                    arr[j]++;
//                }
//            }else{
//                for(int j=h-1; j>=h-num; j--){
//                    arr[j]++;
//                }
//            }
//        }
//
//        int cnt=0, min=Integer.MAX_VALUE;
//        for(int i=0; i<h; i++){
//            if(min > arr[i]){
//                cnt = 1;
//                min = arr[i];
//            } else if(min == arr[i]) cnt++;
//        }
//
//        System.out.println(min + " " + cnt);
//    }
}
