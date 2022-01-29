import java.util.Arrays;
import java.util.Scanner;

public class problem_1288 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int tc = 0; tc<t; tc++){
            String[] arr = {"0","0","0","0","0","0","0","0","0","0"};

            int mul = 2;
            int n = sc.nextInt();
            int sheep = n;
            int v = 0;
            while(Arrays.asList(arr).contains("0")){
                if(sheep<10) {
                    v = Integer.parseInt(arr[sheep]) + 1;
                    arr[sheep] = Integer.toString(v);
                }
                else{
                    int tmp1 = sheep;
                    while(true){
                        int tmp2 = tmp1%10;
                        v = Integer.parseInt(arr[tmp2]) + 1;
                        arr[tmp2] = Integer.toString(v);
                        tmp1 = tmp1/10;
                        if(tmp1<10) {
                            v = Integer.parseInt(arr[tmp1]) + 1;
                            arr[tmp1] = Integer.toString(v);
                            break;
                        }
                    }
                }

                sheep = n * mul;
                mul++;
                //System.out.println(Arrays.toString(arr));

            }
            System.out.printf("#%d %d\n", tc+1, (mul-2)*n);
        }
    }

}
