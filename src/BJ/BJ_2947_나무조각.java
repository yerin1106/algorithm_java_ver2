package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2947_나무조각 {

    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = new int[5];
        for(int i=0; i<5; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        while(true){
            for(int i=1; i<5; i++){
                if(num[i-1] > num[i]) swap(i-1, i);
            }
            if(check(num)) break;
        }
    }

    public static void swap(int a, int b){
        int temp = 0;

        temp = num[a];
        num[a] = num[b];
        num[b] = temp;

        for(int i=0; i<5; i++){
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }

    public static boolean check(int[] arr){
        int[] stand = {1, 2, 3, 4, 5};
        for(int i=0; i<5; i++){
            if(stand[i] != arr[i]) return false;
        }
        return true;
    }
}
