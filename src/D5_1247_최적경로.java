import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_1247_최적경로 {

    static boolean[] visited;
    static int[] arr;
    static int n;
    static int[] tmp;
    static int min = Integer.MAX_VALUE;
    static int[][] cos;
    static int cx, cy, hx, hy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<t+1; tc++){
            min = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            cx = Integer.parseInt(st.nextToken());
            cy = Integer.parseInt(st.nextToken());

            hx = Integer.parseInt(st.nextToken());
            hy = Integer.parseInt(st.nextToken());

            cos = new int[n][2];
            arr = new int[n];
            tmp = new int[n];
            visited = new boolean[n];
            for(int i=0; i<n; i++){
                arr[i] = i;
                for(int j=0; j<2; j++){
                    cos[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            search(0);
            System.out.println("#" + tc + " " + min);
        }
    }

    public static void search(int cnt){
        if(cnt == n){
            int result = 0;
            result = Math.abs(cos[tmp[0]][0]-cx)+Math.abs(cos[tmp[0]][1]-cy);
            for(int i=1; i<n; i++){
                result += Math.abs(cos[tmp[i]][0]-cos[tmp[i-1]][0])+Math.abs(cos[tmp[i]][1]-cos[tmp[i-1]][1]);
            }
            result += Math.abs(cos[tmp[n-1]][0]-hx)+Math.abs(cos[tmp[n-1]][1]-hy);
            if(result < min) min = result;
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i]) continue;

            visited[i] = true;
            tmp[cnt] = arr[i];

            search(cnt+1);
            visited[i] = false;
        }
    }
}
