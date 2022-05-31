package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1261_알고스팟 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][m+1];
        int[][] res = new int[n+1][m+1];
        for(int i=1; i<=n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(tmp[j - 1]);
                res[i][j] = 1000000;
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1});
        res[1][1] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d=0; d<4; d++){
                int rx = cur[0] + dx[d];
                int ry = cur[1] + dy[d];

                if(rx < 1 || ry < 1 || rx >= n+1 || ry >= m+1) continue;

                if(res[cur[0]][cur[1]] + map[rx][ry] < res[rx][ry]){
                    res[rx][ry] = res[cur[0]][cur[1]] + map[rx][ry];
                    q.offer(new int[]{rx, ry});
                }

            }
        }
        System.out.println(res[n][m]);
    }
}
