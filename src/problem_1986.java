import java.util.Scanner;

public class problem_1986 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int n = 0;
        int result = 0;

        for(int i=0; i<t; i++){
            n = sc.nextInt();
            for(int j=1; j<n+1; j++){
                if(j%2 == 1)result += j;
                else result -= j;
            }
            System.out.printf("#%d %d\n", i+1, result);
            result = 0;
        }
    }
}
