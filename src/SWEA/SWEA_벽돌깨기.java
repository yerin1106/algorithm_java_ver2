package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_벽돌깨기 {
    static int n, w, h;
    static int min;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Point{
        int r, c, cnt;

        public Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=t; tc++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            int[][] map = new int[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;

            go(0, map);
            System.out.println("#" + tc + " " + min);
        }
    }

    public static boolean go(int count, int[][] map){
        int result = getRemain(map);

        if(result == 0){
            min = 0;
            return true;
        }

        if(count == n){
            min = Math.min(min, result);
            return false;
        }

        int[][] newMap = new int[h][w];
        for(int c=0; c<w; c++){
            int r = 0;
            while(r<h && map[r][c] == 0) ++r;

            if(r==h) continue;

            copy(map, newMap);

            boom(newMap, r, c);

            down(newMap);

            if(go(count+1, newMap)) return true;
        }
        return false;
    }

    static void boom(int[][] map, int r, int c){
        Queue<Point> queue = new LinkedList<Point>();
        if(map[r][c] > 1){
            queue.offer(new Point(r, c, map[r][c]));
        }
        map[r][c] = 0;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int d = 0; d<4; d++){
                int nr = p.r, nc=p.c;

                for(int k=1; k<p.cnt; k++){
                    nr += dr[d];
                    nc += dc[d];
                    if(nr >= 0 && nr < h && nc >=0 && nc<w &&map[nr][nc] > 0){
                        if(map[nr][nc] > 1) queue.offer(new Point(nr, nc, map[nr][nc]));
                    }
                    map[nr][nc] = 0;
                }
            }
        }
    }

    static ArrayList<Integer> list = new ArrayList<Integer>();
    static void down(int[][] map){
        for(int c=0; c<w; c++){
            int r = h-1;
            while(r>=0){
                if(map[r][c] > 0){
                    list.add(map[r][c]);
                    map[r][c] = 0;
                }
                r--;
            }
            r=h-1;
            for(int a:list){
                map[r--][c] = a;
            }
            list.clear();
        }
    }

    static int getRemain(int[][] map){
        int count = 0;
        for(int r=0; r<h; r++){
            for(int c=0; c<w; c++){
                if(map[r][c] > 0) ++count;
            }
        }
        return count;
    }

    static void copy(int[][] map, int[][] newMap){
        for(int r=0; r<h; r++){
            for(int c=0; c<w; c++){
                newMap[r][c] = map[r][c];
            }
        }
    }

}
