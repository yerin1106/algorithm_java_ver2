import java.util.Scanner;

public class D2_1959_두개의숫자열 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int tc = 0; tc<t; tc++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] a = new int[n];
            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }

            int[] b = new int[m];
            for(int i=0; i<m; i++){
                b[i] = sc.nextInt();
            }

            int s = 0;
            int f = 0;
            int max = 0;
            int result = 0;
            if(n-m > 0){
                s = 0;
                f = m-1;
                while(f<n){
                    result = 0;
                    for(int i = 0; i<m; i++){
                        result += a[s + i] * b[i];
                    }
                    if(result > max) max = result;
                    s++;
                    f++;
                }
            }
            else{
                s = 0;
                f = n-1;
                while(f<m){
                    result = 0;
                    for(int i = 0; i<n; i++){
                        result += a[i] * b[s+i];
                    }
                    if(result > max) max = result;
                    s++;
                    f++;
                }
            }

            System.out.printf("#%d %d\n", tc+1, max);
        }
    }
}
