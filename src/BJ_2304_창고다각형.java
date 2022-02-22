import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_2304_창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int top = arr[0][1];
        int idx = 0;
        int ans = 0;
        for(int i=1; i<n; i++){
            if(top <= arr[i][1]){
                ans += (arr[i][0] - arr[idx][0]) * top;
                top = arr[i][1];
                idx = i;
            }
        }

        int backTop = arr[n-1][1];
        int tmp = arr[n-1][0];
        for(int i=n-2; i>-1; i--){
            if(top == backTop) break;

            if(backTop <= arr[i][1]){
                ans += ((tmp+1) - (arr[i][0]+1)) * backTop;
                backTop = arr[i][1];
                tmp = arr[i][0];
            }
        }

        ans += top;
        System.out.println(ans);
    }

}
