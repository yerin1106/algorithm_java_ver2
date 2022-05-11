package BJ;

import java.io.*;
import java.util.*;

public class BJ_17073_나무위의빗물 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int cnt = 0;
        for(int i=2; i<n+1; i++){
            if(list[i].size() == 1) cnt++; //리프노드는 size가 1
        }

        System.out.printf("%.10f", (double) w/cnt);
        System.out.println();
    }
}
