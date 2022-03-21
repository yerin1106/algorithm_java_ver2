package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8320_직사각형을만드는방법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = n;

        int i = 2;
        while(true){
            if(n/i < i) break;
            for(int j= i; j<=n/i; j++){
                if(i*j <= n) cnt++;
            }
            i++;
        }

        System.out.println(cnt);
    }
}
