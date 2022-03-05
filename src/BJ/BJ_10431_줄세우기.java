package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10431_줄세우기 {

    static int[] student;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int p = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=p; tc++){
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            student = new int[20];

            for(int i=0; i<20; i++){
                student[i] = Integer.parseInt(st.nextToken());
            }

            int[] arr = Arrays.copyOf(student, student.length);

            int ans = 0;
            while(true){
                if(check(arr)) break;

                for(int i=1; i<20; i++){
                    int tmp = 0;
                    if(arr[i] < arr[i-1]){
                        tmp = arr[i];
                        arr[i] = arr[i-1];
                        arr[i-1] = tmp;
                        ans++;
                    }
                }
            }
            System.out.println(tc + " " + ans);

        }
    }

    public static boolean check(int[] arr){
        int[] tmp = Arrays.copyOf(student, student.length);
        Arrays.sort(tmp);

        for(int i=0; i<20; i++){
            if(tmp[i] != arr[i]) return false;
        }
        return true;
    }

}
