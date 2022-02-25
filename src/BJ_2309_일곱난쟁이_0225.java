import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱난쟁이_0225 {

    static int[] n;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = new int[9];
        for(int i=0; i<9; i++){
            n[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(n);

        tmp = new int[7];
        combination(0, 0);
    }

    public static void combination(int cnt, int start){
        if(cnt == 7) {
            int result = 0;
            for(int i=0; i<7; i++){
                result += tmp[i];
            }
            if(result == 100){
                for(int i=0; i<7; i++) System.out.println(tmp[i]);
                System.exit(0);
            }
            return;
        }

        for(int i=start; i<9; i++){
            tmp[cnt] = n[i];
            combination(cnt+1, i+1);
        }
    }
}
