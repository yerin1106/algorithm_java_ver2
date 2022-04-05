package JO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_2577_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        for(int i=0; i<n; i++){
            int[][] tmp = new int[k][2];
            int idx = 0;
            for(int j=i; j<n; j++){
                if(idx == 4) break;
                tmp[idx][0] = arr[j];
                tmp[idx][1] = j;
                idx++;
            }

            idx = 0;
            for(int j=0; j<k; j++){
                if(tmp[j][0] == 0) {
                    tmp[j][0] = arr[idx];
                    tmp[j][1] = idx;
                    idx++;
                }
            }

            int[] cnt = new int[d+1];

            if(arr[(tmp[0][1] + n-1) % n] == c || arr[(tmp[3][1] + 1) % n] == c){
                cnt[c]++;
                for(int j=0; j<4; j++){
                    cnt[tmp[j][0]]++;
                }
            } else{
                for(int j=0; j<4; j++){
                    cnt[tmp[j][0]]++;
                }
            }

            int res = 0;
            for(int j=1; j<d+1; j++){
                if(cnt[j] != 0) res++;
            }

            max = Math.max(res, max);
        }
        System.out.println(max);
    }
}
