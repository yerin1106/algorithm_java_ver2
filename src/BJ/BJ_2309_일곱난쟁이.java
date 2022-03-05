package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱난쟁이 {
    static int[] arr, numbers;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];
        numbers = new int[7];
        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        combination(0,0);
    }

    public static void combination(int cnt, int start){
        if(cnt == 7){
            result = 0;

            for(int i=0; i<7; i++){
                result += numbers[i];
            }
            //System.out.println(Arrays.toString(numbers));
            if(result == 100){
                for(int i=0; i<7; i++){
                    System.out.println(numbers[i]);
                }
                System.exit(0);
            }
            return;
        }
        for(int i=start; i<9; i++){
            numbers[cnt] = arr[i];
            combination(cnt+1, i+1);
        }
    }
}
