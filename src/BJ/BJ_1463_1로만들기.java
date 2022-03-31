package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] tmp = new int[n+1];

        tmp[0] = 0;
        tmp[1] = 0;

        for(int i=2; i<=n; i++){
            int min = Integer.MAX_VALUE;
            if(i>=2 && tmp[i-1]+1 < min) min = tmp[i-1]+1;
            if(i%2==0 && tmp[i/2] + 1 < min) min = tmp[i/2] + 1;
            if(i%3==0 && tmp[i/3] + 1 < min) min = tmp[i/3] + 1;

            tmp[i] = min;
        }
        System.out.println(tmp[n]);
    }
}
