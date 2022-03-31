package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[][] paint = new int[n][3];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        paint[0] = new int[]{r, g, b};

        //System.out.println(Arrays.toString(paint[0]));

        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int R = r + Math.min(paint[i-1][1], paint[i-1][2]);
            int G = g + Math.min(paint[i-1][0], paint[i-1][2]);
            int B = b + Math.min(paint[i-1][0], paint[i-1][1]);

            paint[i] = new int[]{R, G, B};
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            if(paint[n-1][i] < min) min = paint[n-1][i];
        }

        System.out.println(min);
    }
}
