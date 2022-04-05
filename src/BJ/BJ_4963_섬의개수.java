package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 04.05
public class BJ_4963_섬의개수 {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w==0 || h==0) break;

            map = new int[h][w];
            visited = new boolean[h][w];
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j] == 1 && !visited[i][j]) {
                        search(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void search(int x, int y){
        visited[x][y] = true;

        for(int d=0; d<8; d++){
            int rx = x+dx[d];
            int ry = y+dy[d];

            if(rx<0||ry<0||rx>=h||ry>=w||visited[rx][ry]) continue;

            if(map[rx][ry] == 1) search(rx, ry);

        }
    }
}
