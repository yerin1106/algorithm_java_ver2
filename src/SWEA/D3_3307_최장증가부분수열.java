package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_3307_최장증가부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] lis = new int[n];
            int max = 0;
            for(int i=0; i<n; i++){
                lis[i] = 1;
                for(int j=0; j<i; j++){
                    if(arr[j] < arr[i] && lis[i] < lis[j]+1) lis[i] = lis[j]+1;
                }
                if(max<lis[i]) max = lis[i];
            }

            System.out.println("#" + tc + " " + max);
        }
    }
}
