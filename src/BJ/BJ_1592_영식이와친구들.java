package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1592_영식이와친구들 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=1; i<=n; i++){
            arr[i-1] = i;
        }

        int[] tmp = new int[n+1];

        int start = 1;
        int cnt = 0;
        while(true){
            if(tmp[start] == m) {
                cnt--;
                break;
            }
            else{
                // 홀수
                if(tmp[start] % 2 == 1){
                    start = (start+l) % n ;
                    tmp[start]++;
                }
                // 짝수
                else{
                    start = (n-l+start) % n ;
                    tmp[start]++;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
