package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_무선충전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; t++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            int[] a = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }

            int[][] bc = new int[A][4];
            for(int i=0; i<A; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++){
                    bc[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // map 채우기
            String[][] map = new String[11][11];
            for(int i=0; i<A; i++){
                for(int j=1; j<11; j++){
                    for(int k=1; k<11; k++){
                        if(bc[i][2] > Math.abs(j-bc[i][0]) + Math.abs(k-bc[i][1])) break;
                        else{
                            if(map[j][k] == null) map[j][k] = Integer.toString(i);
                            else map[j][k] += Integer.toString(i);
                        }
                    }
                }
            }

            //탐색
            int[] dx = {0, -1, 0, 1, 0};
            int[] dy = {0, 0, 1, 0, -1};

            // 0초일 때 값
            int totalA = 0;
            int totalB = 0;
            if(map[1][1] == null) totalA = 0;
            else{
                String[] line = map[1][1].split("");
                int max = 0;
                for(int i=0; i<line.length; i++){
                    if(max > bc[Integer.parseInt(line[i])][3]) max = bc[Integer.parseInt(line[i])][3];
                }
                totalA = max;
            }

            if(map[10][10] == null) totalB = 0;
            else{
                String[] line = map[10][10].split("");
                int max = 0;
                for(int i=0; i<line.length; i++){
                    if(max > bc[Integer.parseInt(line[i])][3]) max = bc[Integer.parseInt(line[i])][3];
                }
                totalB = max;
            }

            //M만큼 움직이기
            int rax = 1, ray = 1, rbx = 10, rby = 10;
            for(int i=0; i<m; i++){
                rax = dx[a[i]] + rax;
                ray = dy[a[i]] + ray;
                rbx = dx[b[i]] + rbx;
                rby = dy[b[i]] + rby;

                //a와 b가 같은 위치
                if(rax == rbx && ray == rby){
                    String[] line = map[rax][ray].split("");
                    int max = 0;
                    for(int j=0; j<line.length; j++){
                        if(max > bc[Integer.parseInt(line[i])][3]) max = bc[Integer.parseInt(line[i])][3];
                    }
                    totalB += max/2;
                    totalA += max/2;
                }

                else{
                    if(map[rax][ray].equals(map[rbx][rby])){
                        if(map[rax][ray].length() == 1){
                            totalB += bc[Integer.parseInt(map[rbx][rby])][3]/2;
                            totalA += bc[Integer.parseInt(map[rax][ray])][3]/2;
                        }
                        else{
                            Integer[] arr = new Integer[map[rax][ray].length()];
                            String[] tmp = map[rax][ray].split("");
                            for(int j=0; j<arr.length; i++){
                                arr[j] = bc[Integer.parseInt(tmp[j])][3];
                            }
                            Arrays.sort(arr, Collections.reverseOrder());
                            totalB += arr[0];
                            totalA += arr[1];
                        }
                    }
                    else{
                        //서로 다른 bc에서 충전
                        if(map[rax][ray].length() == 1 && map[rbx][rby].length() == 1){
                            totalB += bc[Integer.parseInt(map[rbx][rby])][3];
                            totalA += bc[Integer.parseInt(map[rax][ray])][3];
                        }
                        else{
                            if(map[rax][ray].length() == 1 && map[rbx][rby].length() != 1){
                                totalA += bc[Integer.parseInt(map[rax][ray])][3];

                                Integer[] arr = new Integer[map[rbx][rby].length()-1];
                                String[] tmp = map[rbx][rby].split("");
                                for(int j=0; j<tmp.length; j++){

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
