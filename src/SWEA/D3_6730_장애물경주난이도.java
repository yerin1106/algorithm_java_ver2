package SWEA;

import java.util.Scanner;

public class D3_6730_장애물경주난이도 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int tc = 0; tc<t; tc++){
            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            int[] sub = new int[n-1];
            for(int i=0; i<n-1; i++){
                sub[i] = arr[i] - arr[i+1];
            }

            int min = 0;
            int max = 0;
            for(int i=0; i<sub.length; i++){
                if(sub[i] < 0) {
                    if (sub[i] < min) min = sub[i];
                }
                if(sub[i] > max) max = sub[i];
            }

            System.out.printf("#%d %d %d\n", tc+1, Math.abs(min), max);
        }
    }
}
