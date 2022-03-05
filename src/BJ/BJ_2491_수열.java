package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간초과
public class BJ_2491_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int mode;
        int max = 0;
        int result;
        for(int i=0; i<n; i++){
            result = 1;
            mode = 0;
            int cnt = 0;
            for(int j=i+1; j<n; j++){
                if(mode == 0 && cnt == 0){
                    // 커지는 경우
                    if(arr[j-1] < arr[j]) {
                        mode = 1;
                        cnt = 1;
                    }
                    // 작아지는 경우
                    else if(arr[j-1] > arr[j]) {
                        mode = -1;
                        cnt = 1;
                    }
                }
                if(arr[j-1] == arr[j]) {
                    result++;
                }
                else if(arr[j-1] < arr[j] && mode == 1){
                    result++;
                }
                else if(arr[j-1] > arr[j] && mode == -1){
                    result++;
                }
                if(result != j-i+1) break;
            }
            if(result > max) max = result;
        }
        System.out.println(max);
    }
}