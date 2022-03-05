package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3040_백설공주와일곱난쟁이_0214 {
    static int[] num;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = new int[9];
        result = new int[7];
        for(int i=0; i<9; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        combination(0,0);
    }

    public static void combination(int cnt, int start){
        if(cnt == 7){
            int sum = 0;
            for(int i=0; i<7; i++){
                sum += result[i];
            }
            if(sum == 100){
                for(int i=0; i<7; i++){
                    System.out.println(result[i]);
                }
                System.exit(0);
            }
            return;
        }

        for(int i=start; i<9; i++){
            result[cnt] = num[i];
            combination(cnt+1, i+1);
        }
    }
}
