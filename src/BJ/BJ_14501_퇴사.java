package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501_퇴사 {
    static int[] t;
    static int[] p;
    static int n;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        t = new int[n+1];
        p = new int[n+1];

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        search(1, 0);
        System.out.println(answer);
    }

    public static void search(int day, int cost){
        if(day >= n+1){
            answer = Math.max(answer, cost);
            return;
        }

        if(day + t[day] <= n+1) search(day+t[day], cost+p[day]);
        if(day+1 <= n+1) search(day+1, cost);
    }
}
