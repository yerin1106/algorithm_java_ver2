package undefined;

import java.util.Scanner;

public class problem_2005 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for(int t=0; t<tc; t++){
            int n = sc.nextInt();

            System.out.printf("#%d\n", n);
            int[][] triangle = new int[n][n];
            for(int i=0; i<n; i++){
                for(int j= 0; j<=i; j++){
                    if(i == j) triangle[i][j] = 1;
                    else if(j==0) triangle[i][j] = 1;
                    else triangle[i][j] = triangle[i-1][j] + triangle[i-1][j-1];
                }
            }

            for(int i=0; i<n; i++){
                for(int j= 0; j<=i; j++){
                    System.out.print(triangle[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
