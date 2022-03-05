package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1244_스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine()); //스위치 개수

        int[] switchArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        int stu = Integer.parseInt(br.readLine());

        for(int i=0; i<stu; i++){
           st  = new StringTokenizer(br.readLine());
           int g = Integer.parseInt(st.nextToken());
           int num = Integer.parseInt(st.nextToken());
           //System.out.println(g + " " + num);

           // 남학생
           if(g == 1){
               for(int j=0; j<n; j++){
                   if((j+1) % num == 0){
                       //System.out.println(j);
                       if(switchArr[j] == 0) switchArr[j] = 1;
                       else switchArr[j] = 0;
                   }
               }
           }

           // 여학생
           else{
               if(switchArr[num-1] == 0) switchArr[num-1] = 1;
               else switchArr[num-1] = 0;

               int idx = 1;
               while(true){
                   if(num -1 -idx >= 0 && num -1 +idx < n){
                       if(switchArr[num -1 -idx] == switchArr[num -1 +idx]){
                           if(switchArr[num -1 -idx] == 0) {
                               switchArr[num -1 -idx] = 1;
                               switchArr[num -1 +idx] = 1;
                           }
                           else{
                               switchArr[num -1 -idx] = 0;
                               switchArr[num -1 +idx] = 0;
                           }
                       }
                       else{
                           break;
                       }
                       idx++;
                   }
                   else
                       break;
               }
           }
           //System.out.println(Arrays.toString(switchArr));
        }

        for(int i=0; i<n; i++){
            if(i != 0 && i % 20 == 0) System.out.println();
            System.out.print(switchArr[i] + " ");
        }


    }
}
