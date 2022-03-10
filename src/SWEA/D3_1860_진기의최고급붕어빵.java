package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_1860_진기의최고급붕어빵 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            st = new StringTokenizer(br.readLine());
            int n  = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] people = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                people[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(people);

            int cnt = 0;
            int bread = 0;
            boolean flag = false;

            //System.out.println(Arrays.toString(people));
            for(int i=0; i<=people[n-1]; i++){
                //System.out.println(i +  " " + people[cnt] + " " + bread);
                if(i!=0 && i%m == 0){
                    bread += k;
                }

                if(i == people[cnt]){
                    //System.out.println(people[cnt] + " " + bread);
                    cnt++;
                    if(bread == 0){
                        System.out.println("#" + tc + " Impossible");
                        flag = true;
                        break;
                    }
                    bread--;
                }
            }
            if(!flag){
                System.out.println("#" + tc + " Possible");
            }
        }
    }
}
