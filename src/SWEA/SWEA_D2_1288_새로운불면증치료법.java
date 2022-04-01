package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D2_1288_새로운불면증치료법 {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            int n = Integer.parseInt(br.readLine());

            arr = new int[10];
            System.out.println("#" + tc + " " + solution(n));
        }
    }

    public static int solution(int n){
        int ans = 1;
        while(true){
            if(check()) return --ans * n;

            int result = ans * n;
            String[] tmp = Integer.toString(result).split("");
            for(int i=0; i<tmp.length; i++){
                arr[Integer.parseInt(tmp[i])]++;
            }
            ans++;
        }
    }

    public static boolean check(){
        for(int i=0; i<10; i++){
            if(arr[i] == 0) return false;
        }
        return true;
    }
}
