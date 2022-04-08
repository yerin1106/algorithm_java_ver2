package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17135_캐슬디펜스 {

    static int n, m, d;
    static int[][] map;
    static int[] num, input;

    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        input = new int[m];
        num = new int[3];
        for(int i=0; i<m; i++){
            input[i] = i;
        }

        combination(0, 0);

        System.out.println(max);
    }

    public static void combination(int cnt, int start){
        if(cnt == 3){
//            System.out.println(Arrays.toString(num));
            int[][] origin = new int[n][m];
            copy(map, origin);

            int res = game(num);
            max = Math.max(max, res);
            copy(origin, map);

            return;
        }
        for(int i=start; i<m; i++){
            num[cnt] = input[i];
            combination(cnt+1, i+1);
        }
    }



    public static int game(int[] num){
        int res = 0;

        for(int t=0; t<n; t++){
            boolean[][] visited = new boolean[n][m];
            for(int s = 0; s<3; s++){

                int minD = Integer.MAX_VALUE; // 최소 거리
                int minR = Integer.MAX_VALUE; // 최소 거리의 y좌표
                int minC = Integer.MAX_VALUE; // 최소 거리의 x좌표

                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){ // 적 찾기
                        if(map[i][j] == 1){
                            int des = Math.abs(n-i) + Math.abs(num[s] - j);
                            if(minD >= des){
                                if(minD > des) {
                                    minD = des;
                                    minR = i;
                                    minC = j;
                                } else {
                                    // 현재 구한 최소 거리와 지금 구한 최소 거리가 같을 경우,
                                    // 가장 왼쪽 적부터 처지해야하므로 x좌표가 더 작은지 검사해야 함.
                                    if (minC > j) {
                                        minR = i;
                                        minC = j;
                                    }
                                }
                            }
                        }
                    }
                }

                if (minD <= d) {
                    visited[minR][minC] = true;
                }
            }

            // visited가 true인 좌표만 적을 처지한다.
            // 궁수가 같은 적을 쏠 수도 있기 때문에 바로 바로 map[i][j] = 0하면 안 된다.
            // 바로 0으로 하면 그거 제외하고 가까운 것을 찾기 때문 (틀린 포인트!!!)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j]) {
                        map[i][j] = 0;
                        res++;
                    }
                }
            }

            // 적 내리기
            int[][] copyMap = new int[n][m];
            for(int i=0; i<n-1; i++){
                for(int j=0; j<m; j++){
                    copyMap[i+1][j] = map[i][j];
                }
            }
            copy(copyMap, map);
        }

        return res;
    }

    public static void copy(int[][] a, int[][] b){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                b[i][j] = a[i][j];
            }
        }
    }
}
