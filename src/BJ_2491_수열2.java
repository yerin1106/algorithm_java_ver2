import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2491_수열2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 1;
        int asc = 1;
        for(int i=0; i<n-1; i++){
            if(arr[i] <= arr[i+1]) asc++;
            else asc = 1;
            result = Math.max(result, asc);
        }

        int desc = 1;
        for(int i=0; i<n-1; i++){
            if(arr[i] >= arr[i+1]) desc++;
            else desc = 1;
            result = Math.max(result, desc);
        }
        System.out.println(result);
    }
}
