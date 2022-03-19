package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2804_크러스워드만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();

        boolean flag = false;
        int r = 0, c = 0;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<b.length; j++){
                if(a[i] == b[j]){
                    r = i;
                    c = j;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        //System.out.println(r + " " + c);

        char[][] arr = new char[b.length][a.length];
        for(int i=0; i<b.length; i++){
            for(int j=0; j<a.length; j++){
                if(j == r) arr[i][j] = b[i];
                else if(i == c) arr[i][j] = a[j];
                else arr[i][j] = '.';
            }
        }


        for(int i=0; i<b.length; i++){
            for(int j=0; j<a.length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
