import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759_암호만들기 {
    static int l, c;
    static String[] ans;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        //System.out.println(l +" "+c);

        arr = br.readLine().split(" ");
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));

        ans = new String[l];
        comb(0, 0);
    }

    public static void comb(int cnt, int start){
        if(cnt == l) {
            //System.out.println(Arrays.toString(ans));
            int vowel = 0; //모음
            int con = 0; //자음
            for(int i=0; i<l; i++){
                if(ans[i].equals("a") || ans[i].equals("e") || ans[i].equals("i") ||
                ans[i].equals("o") || ans[i].equals("u")) vowel++;
                else con++;
            }
            if(vowel > 0 && con >1){
                for(int i=0; i<l; i++){
                    System.out.print(ans[i]);
                }
                System.out.println();
            }
            return;
        }

        for(int i=start; i < c; i++){
            //System.out.println(arr[i]);
            ans[cnt] = arr[i];
            comb(cnt+1, i+1);
        }
    }
}
