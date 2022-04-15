package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) queue.offer(new int[]{i, j});
            }
        }//입력

//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        int max = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int day = map[current[0]][current[1]];

            for(int i=0; i<4; i++){
                int rx = current[0] + dx[i];
                int ry = current[1] + dy[i];

                if(rx < 0 || ry < 0 || rx >= n || ry >= m) continue;

                if(map[rx][ry] == 0){
                    if(max < day) max = day;
                    map[rx][ry] = day+1;
                    queue.offer(new int[]{rx, ry});
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max);
    }
}
