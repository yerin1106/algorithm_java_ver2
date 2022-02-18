import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3234_준환이의양팔저울 {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int[] tmpLeft;

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<t+1; tc++){
            ans = 0;
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            arr = new int[n];
            visited = new boolean[n];
            tmpLeft = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            perm1(0);

            System.out.println("#" + tc + " " + ans);
        }
    }

    public static void perm1(int cnt){
        if(cnt == n){
            //System.out.println(Arrays.toString(tmpLeft));
            divide(0,0,0);
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i]) continue;

            visited[i] = true;
            tmpLeft[cnt] = arr[i];

            perm1(cnt+1);
            visited[i] = false;
        }
    }

    public static void divide(int cnt, int L, int R){
        if(cnt == n) {
            ans++;
            return;
        }
        divide(cnt+1, L+tmpLeft[cnt], R);

        if(L >= R+tmpLeft[cnt]){
            divide(cnt+1, L, R+tmpLeft[cnt]);
        }
    }

    //make right
//    public static void perm2(int cnt){
//        if(cnt == n){
//            System.out.println(Arrays.toString(tmpLeft));
//            System.out.println(Arrays.toString(tmpRight));
//            int left = 0;
//            int right = 0;
//            int result = 0;
//            for(int i=0; i<n; i++){
//                left += tmpLeft[i];
//                right += tmpRight[i];
//                if(left >= right) result++;
//            }
//            if(result == n) ans++;
//            return;
//        }
//        for(int i=0; i<n; i++){
//            if(visited2[i]) continue;
//
//            visited2[i] = true;
//            tmpRight[cnt] = arr2[i];
//            perm2(cnt+1);
//            visited2[i] = false;
//        }
//    }
}
