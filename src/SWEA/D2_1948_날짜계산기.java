package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1948_날짜계산기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        int result = 0;
        int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int tc=1; tc<=t; tc++){
            st = new StringTokenizer(br.readLine());
            result = 0;

            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());

            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            if(m1 == m2) result = d2-d1+1;
            else{
                result += day[m1]-d1+1;
                result += d2;
                for(int i=m1+1; i<m2; i++){
                    result += day[i];
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
