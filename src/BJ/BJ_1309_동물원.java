package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1309_동물원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 3;

        for(int i=2; i<n+1; i++){
            arr[i] = ((arr[i-1]*2) + arr[i-2]) % 9901;
        }

        System.out.println(arr[n]);
    }
}
