import javax.jws.soap.SOAPBinding;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
    static int n;
    static int[][] s;
    static int[] sn;
    static int[] numbers1;
    static int[] numbers2;

    static boolean[] isSelected1;
    static boolean[] isSelected2;
    static int[] tmp1;
    static int[] tmp2;

    static int total1;
    static int total2;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc<t; tc++){
            n = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            sn = new int[n];
            for(int i=0; i<n; i++){
                sn[i] = i;
            }

            s = new int[n][n];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    s[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            numbers1 = new int[n/2];
            numbers2 = new int[n/2];
            combination(0, 0);

            System.out.printf("#%d %d\n", tc+1, min);
        }
    }

    public static void combination(int cnt, int start){
        if(cnt == n/2) {
            boolean check;
            int count = 0;
            for(int i=0; i<n; i++){
                check = true;
                for(int j=0; j<n/2; j++){
                    if(numbers1[j] == sn[i]) check = false;
                }
                if(check) {
                    numbers2[count] = sn[i];
                    count++;
                }
            }

            //순열 numbers1
            isSelected1 = new boolean[n/2];
            tmp1 = new int[2];
            total1 = 0;
            permutation1(0);

            //순열 numbers2
            isSelected2 = new boolean[n/2];
            tmp2 = new int[2];
            total2 = 0;
            permutation2(0);

            //System.out.println(total1 + " " + total2);
            if(Math.abs(total1 - total2) < min) min = Math.abs(total1 - total2);
            return;
        }
        for(int i=start; i<n; i++){
            numbers1[cnt] = sn[i];
            combination(cnt+1, i+1);
        }
    }

    public static void permutation1(int cnt){
        //System.out.println("perm1");
        if(cnt == 2){
            //System.out.println(Arrays.toString(tmp1));
            total1 += s[tmp1[0]][tmp1[1]];
            return;
        }

        for(int i=0; i<n/2; i++){
            if(isSelected1[i]) continue;

            isSelected1[i] = true;
            tmp1[cnt] = numbers1[i];

            permutation1(cnt+1);
            isSelected1[i] = false;
        }
    }

    public static void permutation2(int cnt){
        if(cnt == 2){
            //System.out.println(Arrays.toString(tmp2));
            total2 += s[tmp2[0]][tmp2[1]];
            return;
        }

        for(int i=0; i<n/2; i++){
            if(isSelected2[i]) continue;

            isSelected2[i] = true;
            tmp2[cnt] = numbers2[i];

            permutation2(cnt+1);
            isSelected2[i] = false;
        }
    }
}
