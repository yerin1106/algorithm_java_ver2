package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2583_영역구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int a=0; a<k; a++){
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for(int i=x1; i<x2; i++){
                for(int j=y1; j<y2; j++){
                    map[i][j] = -1;
                }
            }
        }

//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        ArrayList<Integer> res = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    q.offer(new int[]{i, j});
                    map[i][j] = 1;
                    int cnt = 1;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();

                        for(int d=0; d<4; d++){
                            int rx = cur[0] + dx[d];
                            int ry = cur[1] + dy[d];

                            if(rx < 0 || ry< 0 || rx >= n || ry >= m || map[rx][ry] != 0) continue;

                            q.offer(new int[]{rx, ry});
                            map[rx][ry] = 1;
                            cnt++;
                        }
                    }
                    res.add(cnt);
                }
            }
        }
//        System.out.println("-----------------------");
//        for(int i=0; i<n; i++){
//            for(int j=0; j<m; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(res.size());
        Collections.sort(res);
        for(int i=0; i< res.size(); i++){
            System.out.print(res.get(i) + " ");
        }
    }
}
