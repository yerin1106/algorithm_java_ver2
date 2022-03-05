package undefined;

import java.util.Arrays;
import java.util.Scanner;

public class problem_1984 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for(int i=0; i<tc; i++){
            int[] arr = new int[10];
            for(int j=0; j<10; j++){
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            int sum = 0;
            for(int j=1; j<9; j++){
                sum += arr[j];
            }
            System.out.printf("#%d %.0f\n", i+1, (double)sum/8);
        }
    }
}
