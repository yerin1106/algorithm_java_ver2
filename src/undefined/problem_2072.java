package undefined;

import java.util.Scanner;

public class problem_2072 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int num = 0;
            int sum = 0;
            for(int j=0; j<10; j++){
                num = sc.nextInt();
                if(num % 2 == 1) sum += num;
            }

            System.out.println("#" + (i+1) + " " + sum);
        }
    }
}
