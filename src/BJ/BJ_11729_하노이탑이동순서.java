package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11729_하노이탑이동순서 {
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println((int)Math.pow(2,n) - 1);
        hanoi(n, 1 , 2, 3);

        sb.insert(0, cnt + "\n");
        System.out.println(sb);
    }

    public static void hanoi(int n, int from, int temp, int to){
        ++cnt;
        if(n==1) {
            sb.append(from + " " + to + "\n");
            return;
        }

        hanoi(n-1, from, to, temp);
        sb.append(from + " " + to + "\n");
        hanoi(n-1, temp, from, to);
    }
}
