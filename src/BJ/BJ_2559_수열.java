package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2559_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int roop = n - (k -1);

        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[roop];
        for(int i=0; i<roop; i++){
            for(int j=i; j<i+k; j++){
                ans[i] += num[j];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<roop; i++){
            if(max < ans[i]) max = ans[i];
        }

        System.out.println(max);
    }
}
